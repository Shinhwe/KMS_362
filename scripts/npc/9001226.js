var status = 0;

function start() {
    status = -1;
    action(1, 0, 0);
}

function action(mode, type, selection) {
    if (mode == 1)
        status++;
    else
        status--;
    if (status == 0) {
        cm.warp(cm.getPlayer().getMapId() + 200, 0);
        cm.dispose();
    }
}
