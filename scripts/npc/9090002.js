﻿var status = -1;

function start() {
    status = -1;
    action(1, 0, 0);
}

function action(mode, type, selection) {
    setting = [
        ["MoonPig", 5, 910010200, 250],
    ]
    name = ["노멀"];
    if (mode == -1 || mode == 0) {
        cm.dispose();
        return;
    }
    if (mode == 1) {
        status++;
    }

    if (status == 0) {
        talk = "#fn나눔고딕##fs14#히든 스트리트 돼지의 마을로 이동시켜드릴까요?\r\n\r\n";
	talk += "#L0##k돼지의 마을 입장하기#k#l\r\n";
        cm.sendSimple(talk);
    } else if (status == 1) {
        st = selection;
        if (cm.getParty() == null) {
            cm.sendOkS("1인 이상 파티를 맺어야만 입장할 수 있습니다.", 0x26);
            cm.dispose();
            return;
        } else if (cm.getPlayerCount(910010200) >= 1) {
            cm.sendOkS("이미 누군가가 돼지의 마을에 있습니다.\r\n다른채널을 이용 해 주세요.", 0x26);
            cm.dispose();
            return;
        } else if (!cm.isLeader()) {
            cm.sendOkS("파티장만이 입장을 신청할 수 있습니다.", 0x26);
            cm.dispose();
            return;
	} else if (!cm.allMembersHere()) {
	    cm.sendOk("모든 멤버가 같은 장소에 있어야 합니다.");
	    cm.dispose();
            return;
        }
        if (!cm.isBossAvailable(setting[st][0], setting[st][1])) {
            talk = "파티원 중 "
            for (i = 0; i < cm.BossNotAvailableChrList(setting[st][0], setting[st][1]).length; i++) {
                if (i != 0) {
                    talk += ", "
                }
                talk += "#b#e" + cm.BossNotAvailableChrList(setting[st][0], setting[st][1])[i] + ""
            }
            talk += "#k#n님이 오늘 입장했습니다. 돼지의 마을은 하루에 " + setting[st][1] + "번만 도전하실 수 있습니다.";
            cm.sendOkS(talk, 0x26);
            cm.dispose();
            return;
        } else if (!cm.isLevelAvailable(setting[st][3])) {
            talk = "파티원 중 "
            for (i = 0; i < cm.LevelNotAvailableChrList(setting[st][3]).length; i++) {
                if (i != 0) {
                    talk += ", "
                }
                talk += "#b#e" + cm.LevelNotAvailableChrList(setting[st][3])[i] + ""
            }
            talk += "#k#n님의 레벨이 부족합니다. 돼지의 마을은 " + setting[st][3] + " 레벨 이상만 입장 가능합니다.";
            cm.sendOkS(talk, 0x26);
            cm.dispose();
            return;
        } else {
            cm.addBoss(setting[st][0]);
            em = cm.getEventManager(setting[st][0]);
            if (em != null) {

                cm.getEventManager(setting[st][0]).startInstance_Party(setting[st][2] + "", cm.getPlayer());
            }
            cm.dispose();
        }
    }
}
