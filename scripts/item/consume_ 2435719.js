var box = 2435719;

function start() {
	St = -1;
	action(1, 0, 0);
}

function action(mode, type, count) {
	if (mode == -1 || mode == 0) {
		cm.dispose();
		return;
	}
	if (mode == 1) {
		St++;
	}
	if (St == 0) {
      cm.sendGetNumber("要開啟多少個核心寶石(每次最多同時開啟 500 個)?", 1, 1, 500);
	} else if (St == 1) {
		if (!cm.haveItem(2437760, count)) {
      cm.sendOk("你沒有那麽多核心寶石!");
			cm.dispose();
			return;
		}
		cm.multiUseCoreStone(box, count)
		cm.dispose();
	}
}