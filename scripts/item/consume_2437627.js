﻿var status;
importPackage(Packages.server);
importPackage(Packages.client.inventory);
importPackage(Packages.server);
importPackage(Packages.server.items);
one = Math.floor(Math.random() * 5) + 1 // 최소 10 최대 35 , 혼테일
function start() {
    status = -1;
    action(1, 1, 0);
}

function action(mode, type, selection) {
    if (mode == -1) {
        cm.dispose();
        return;
    }
    if (mode == 0) {
        status --;
    }
    if (mode == 1) {
        status++;
    }
        if (status == 0) {
		cm.getPlayer().gainDonationPoint(4000000);
		cm.gainItem(5068305, 48);
                cm.gainItem(4033114, 1500); // 응고된악의정수
                cm.gainItem(5062005, 30); // 어메이징큐브
                 cm.gainItem(3994718, 30); //돌덩이
		cm.gainItem(2437627, -1);
		cm.dispose();
	}
}

