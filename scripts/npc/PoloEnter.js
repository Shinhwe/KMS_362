var enter = "\r\n";
var seld = -1;

var maps = [];

// 993000000 : 현상금 사냥
// 993000100 : 성벽 지키기
// 993000650 : 스톰윙 출몰지역

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
        cm.sendSimpleS("現在剛好要去狩獵的路上, 你要不要一起來狩獵魔物?" + enter + "#b#L1#一同前往" + enter + "#L2#拒絕一同前往", 1);
    } else if (status == 2) {
        cm.dispose();
        switch (sel) {
            case 1:
                cm.getPlayer().addKV("flameWolfReturnMap", "");
                cm.getPlayer().addKV("poloFrittoReturnMap", cm.getPlayer().getMapId());
                if (cm.getClient().getChannelServer().getMapFactory().getMap(993000000).characterSize() == 0) {
                    // 守護賞金獵人
                    maps.push(993000000);
                }
                if (cm.getClient().getChannelServer().getMapFactory().getMap(993000100).characterSize() == 0) {
                    // 塔防
                    maps.push(993000100);
                }
                if (maps.length == 0) {
                    cm.sendOk("現在暫時沒有可用的地圖(還需要編碼地圖單實例)");
                    return;
                }
                cm.warp(maps[Packages.server.Randomizer.nextInt(maps.length)], 0);
                break;
            case 2:
                cm.sendOk("好吧, 我會在這裏等你 1 分鐘, 如果你改變心意隨時可以來找我");
                break;
        }
    }
}