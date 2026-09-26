function solution(video_len, pos, op_start, op_end, commands) {
    const toSec = (str) => {
        const [mm, ss] = str.split(':').map(Number);
        return mm * 60 + ss;
    };
    const toStr = (sec) => {
        const mm = String(Math.floor(sec / 60)).padStart(2, '0');
        const ss = String(sec % 60).padStart(2, '0');
        return `${mm}:${ss}`;
    };
    
    const len = toSec(video_len);
    const start = toSec(op_start);
    const end = toSec(op_end);
    let cur = toSec(pos);
    
    //초기 위치가 오프닝 구간에 있는 경우도 즉시 건너뛰기
    if (cur >= start && cur <= end) {
        cur = end;
    }
    
    for (const cmd of commands) {
        if (cmd == 'prev') {
            cur = Math.max(0, cur - 10);
        } else {
            cur = Math.min(len, cur + 10);
        }
        if (cur >= start && cur <= end) {
            cur = end;
        }
    }
    return toStr(cur);
}