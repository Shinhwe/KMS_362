box = 2437760;
var seld = -1;

function start() {
	St = -1;
	action(1, 0, 0);
}

function action(mode, type, selection) {
	if (mode == -1 || mode == 0) {
		cm.dispose();
		return;
	}
	if (mode == 1) {
		St++;
	}
	if (St == 0) {
        var text = "#fs14#請選擇要獲取的秘法符文, 每張兌換券可以獲得 5 個秘法符文.\r\n";
		text += "#L1##b#i1712001##z1712001#\r\n";
		text += "#L2##b#i1712002##z1712002#\r\n";
		text += "#L3##b#i1712003##z1712003#\r\n";
		text += "#L4##b#i1712004##z1712004#\r\n";
		text += "#L5##b#i1712005##z1712005#\r\n";
		text += "#L6##b#i1712006##z1712006#\r\n";
		cm.sendYesNo(text);
	} else if (St == 1) {
		seld = selection;
        cm.sendGetNumber("要使用多少張兌換券?", 1, 1, 100);
	} else if (St == 2) {
		if (!cm.canHold(1712000 + seld, 5 * seld)) {
            cm.sendOk("背包空間不足, 裝備欄位需要有 " + (5 * seld) + " 個空間, 請檢查!");
			cm.dispose();
			return;
		}
		if (!cm.haveItem(2437760, selection)) {
            cm.sendOk("你沒有那麽多兌換券!");
			cm.dispose();
			return;
		}
		cm.gainItem(1712000 + seld, 5 * selection);
		cm.gainItem(2437760, -1 * selection);
        cm.sendOk("成功獲得對應的秘法符文!");
		cm.dispose();
	}
}
