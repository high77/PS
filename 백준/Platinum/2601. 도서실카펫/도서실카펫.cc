#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

const int MAX_Y = 1000005;
int tree[MAX_Y * 4];
int lazy[MAX_Y * 4];

// 세그먼트 트리 지연 평가(Lazy Propagation)
void push_down(int node) {
    if (lazy[node] != 0) {
        tree[node * 2] += lazy[node];
        lazy[node * 2] += lazy[node];
        tree[node * 2 + 1] += lazy[node];
        lazy[node * 2 + 1] += lazy[node];
        lazy[node] = 0;
    }
}

// 구간 업데이트
void update(int node, int start, int end, int l, int r, int val) {
    if (r < start || end < l) return;
    if (l <= start && end <= r) {
        tree[node] += val;
        lazy[node] += val;
        return;
    }
    push_down(node);
    int mid = (start + end) / 2;
    update(node * 2, start, mid, l, r, val);
    update(node * 2 + 1, mid + 1, end, l, r, val);
    tree[node] = max(tree[node * 2], tree[node * 2 + 1]);
}

struct Event {
    int x, type, y1, y2;
    bool operator<(const Event& other) const {
        return x < other.x;
    }
};

int main() {
    // 입출력 최적화
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int Lx1, Ly1, Lx2, Ly2;
    if (!(cin >> Lx1 >> Ly1 >> Lx2 >> Ly2)) return 0;

    int L, N;
    cin >> L >> N;

    // 카펫의 왼쪽 아래 꼭짓점이 위치할 수 있는 도서실 내부의 절대 범위
    int LX_min = Lx1;
    int LX_max = Lx2 - L;
    int LY_min = Ly2;
    int LY_max = Ly1 - L;

    vector<Event> events;
    events.reserve(N * 2);

    for (int i = 0; i < N; ++i) {
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;

        // 얼룩 자체가 카펫보다 크면 덮을 수 없음
        if (x2 - x1 > L || y1 - y2 > L) continue;

        // 현재 얼룩을 덮기 위한 카펫의 유효 좌표와 도서실 경계의 교집합 산출
        int vX_min = max(x2 - L, LX_min);
        int vX_max = min(x1, LX_max);
        int vY_min = max(y1 - L, LY_min);
        int vY_max = min(y2, LY_max);

        // 교집합이 유효하지 않으면 덮을 수 없는 위치
        if (vX_min > vX_max || vY_min > vY_max) continue;

        // X축 스위핑을 위한 시작과 끝 이벤트 삽입
        events.push_back({vX_min, 1, vY_min, vY_max});
        events.push_back({vX_max + 1, -1, vY_min, vY_max});
    }

    // X좌표 오름차순 정렬
    sort(events.begin(), events.end());

    int max_overlaps = 0;
    int n_events = events.size();
    int i = 0;

    // 스위핑 진행
    while (i < n_events) {
        int curr_x = events[i].x;
        // 동일한 X좌표에서 발생하는 모든 이벤트를 한 번에 처리
        while (i < n_events && events[i].x == curr_x) {
            update(1, 0, MAX_Y, events[i].y1, events[i].y2, events[i].type);
            i++;
        }
        // 이벤트 갱신 후 루트 노드의 최댓값으로 정답 갱신
        max_overlaps = max(max_overlaps, tree[1]);
    }

    cout << max_overlaps << "\n";

    return 0;
}