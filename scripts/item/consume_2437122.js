var enter = "\r\n";
var seld = -1;

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
		cm.dispose();
		cm.gainItem(2437122, -1);
		cm.MakePmdrItem(2437122, 2);
	}
}
