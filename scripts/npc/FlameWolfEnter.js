var enter = "\r\n";
var seld = -1;

var map = 993000500;

function start() {
    status = -1;
    action(1, 0, 0);
}

function action(mode, type, sel) {
    if (mode == 1) {
        status++;
    } else {
        cm.dispose();
        return;
    }
    if (status == 0) {
        cm.sendNextS("我是楓之谷世界最厲害的賞金獵人 #r#e波羅#k#n. 正在和" + enter + "弟弟 #b#e普里托#k#n一起擊退魔物!", 1);
    } else if (status == 1) {
        cm.sendSimpleS("우리 형제가 오랜 시간 추격하던 최강의 몬스터 #r#e불꽃늑대#k#n의 소굴을 마침내 찾아냈다. 녀석은 여행자들을 닥치는대로 약탈하는 아주 악랄한 놈이지... 어때, 나와 함께 녀석을 퇴치하러 가겠나?" + enter + "#b#L1#一同前往." + enter + "#L2#拒絕一同前往", 1);
    } else if (status == 2) {
        switch (sel) {
            case 1:
                cm.getPlayer().addKV("flameWolfReturnMap", cm.getPlayer().getMapId());
                cm.warp(map);
                break;
            case 2:
                cm.sendOk("好吧, 我會在這裏等你 1 分鐘, 如果你改變心意隨時可以來找我");
                break;
        }
        cm.dispose();
    }
}