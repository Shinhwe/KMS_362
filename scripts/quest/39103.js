importPackage(Packages.tools.packet);
importPackage(java.lang);
importPackage(java.util);
importPackage(java.awt);
importPackage(Packages.server);
importPackage(Packages.constants);
importPackage(Packages.client.inventory);

status = -1;
function end(mode, type, selection) {

    if (mode == -1) {
        qm.dispose();
        return;
    }
    if (mode == 0) {
        if (status == 1) {
            qm.sendOk("나는 항상 같은자리에 있으니 언제라도 다시 말을 걸어주게.");
            qm.dispose();
            return;
        } else {
            status--;
        }
    }
    if (mode == 1) {
        status++;
    }

    if (status == 0) {
        qm.sendNext("오오. 말랑이, 수고 많았군. 필요한 물건을 잘 모아와 주었군.\r\n정말 하기 힘든 일인데... 앞으로도 잘 부탁하네, 말랑이.");
    } else if (status == 1) {
        qm.forceCompleteQuest();
        qm.removeAll(4034282);
        str = qm.getPlayer().getV("ArcQuest6");
        ab = str.split(",");
        var clear = 0;
        for (var a = 0; a < ab.length; a++) {
            if (qm.getPlayer().getQuestStatus(ab[a]) == 2) {
                clear++
            }
        }
        qm.getPlayer().setKeyValue(39100, "FC", clear + "");
        qm.getClient().send(CField.UIPacket.detailShowInfo("경험치 50,000,000 획득!", 3, 20, 20));
        qm.gainExp(50000000);
        qm.dispose();
    }
}
