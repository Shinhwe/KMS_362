/*

     [ PlatinumMS ]

     이 스크립트는 PlatinumMS 에서 제작한 스크립트 입니다.

     스크립트 용도 : 25레벨 장비상자

*/

importPackage(Packages.client.items);
var status = -1;

function start() {
    status = -1;
    action(1, 1, 0);
}

function action(mode, type, selection) {
    if (mode < 0) {
        cm.dispose();
    return;
    } else {
        if (mode == 1)
            status++;
        else
            status--;
        if (status == 0) {
                   var leftslot = cm.getPlayer().getInventory(MapleInventoryType.EQUIP).getNumFreeSlot();
            if (leftslot < 9) {
                cm.sendOk("인벤토리 공간이 최소한 9칸은 필요합니다. 장비 탭의 공간을 9칸이상 비워주신 후 다시 열어주세요.");
                cm.dispose();
                return;
            }
            
            switch (cm.getPlayer().getJob()) {
                case 100:
                case 1100:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040170, 1);
                        cm.gainItem(1060159, 1);
                    } else {
                        cm.gainItem(1041172, 1);
                        cm.gainItem(1061182, 1);

                    }
                    cm.gainItem(1003312, 1);
                    cm.gainItem(1072574, 1);
                    cm.gainItem(1082356, 1); 
                    cm.gainItem(1092098, 1);
                    cm.gainItem(1312081, 1);
                    cm.gainItem(1402122, 1);
                    cm.gainItem(1412080, 1);
                    break;
                case 2100:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040170, 1);
                        cm.gainItem(1060159, 1);
                    } else {
                        cm.gainItem(1041172, 1);
                        cm.gainItem(1061182, 1);

                    }
                    cm.gainItem(1003312, 1);
                    cm.gainItem(1072574, 1);
                    cm.gainItem(1082356, 1); 
                    cm.gainItem(1092098, 1);
                    break;
                case 3100:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040170, 1);
                        cm.gainItem(1060159, 1);
                    } else {
                        cm.gainItem(1041172, 1);
                        cm.gainItem(1061182, 1);

                    }
                    cm.gainItem(1003312, 1);
                    cm.gainItem(1072574, 1);
                    cm.gainItem(1082356, 1); 
                    cm.gainItem(1092098, 1);
                    cm.gainItem(1312081, 1);
                    break;
                case 5100:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040170, 1);
                        cm.gainItem(1060159, 1);
                    } else {
                        cm.gainItem(1041172, 1);
                        cm.gainItem(1061182, 1);

                    }
                    cm.gainItem(1003312, 1);
                    cm.gainItem(1072574, 1);
                    cm.gainItem(1082356, 1); 
                    cm.gainItem(1092098, 1);
                    break;
                case 200:
                case 1200:
                case 2210:
                case 3200:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1050197, 1);
                        //cm.gainItem(1060156, 1);
                    } else {
                        cm.gainItem(1041175, 1);
                        cm.gainItem(1061184, 1);
                    }
                    cm.gainItem(1072575, 1);
                    cm.gainItem(1082357, 1);
                    cm.gainItem(1382135, 1);
                    break;
                case 300:
                case 1300:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040171, 1);
                        cm.gainItem(1062146, 1);
                    } else {
                        cm.gainItem(1041173, 1);
                        cm.gainItem(1062146, 1);
                    }
                    cm.gainItem(1003313, 1);
                    cm.gainItem(1082358, 1);
                    cm.gainItem(1072576, 1);
                    cm.gainItem(1452140, 1);
                    break;
                case 2300:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040171, 1);
                        //cm.gainItem(1062146, 1);
                    } else {
                        cm.gainItem(1041173, 1);
                        cm.gainItem(1062146, 1);
                    }
                    cm.gainItem(1003313, 1);
                    cm.gainItem(1082358, 1);
                    cm.gainItem(1072576, 1);
                    cm.gainItem(1522031, 1);
                    break;
                case 3300:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040171, 1);
                        cm.gainItem(1062146, 1);
                    } else {
                        cm.gainItem(1041173, 1);
                        cm.gainItem(1062146, 1);
                    }
                    cm.gainItem(1003313, 1);
                    cm.gainItem(1082358, 1);
                    cm.gainItem(1072576, 1);
                    cm.gainItem(1462129, 1);
                    break;
                case 400:
                case 1400:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040172, 1);
                        cm.gainItem(1060160, 1);
                    } else {
                        cm.gainItem(1041174, 1);
                        cm.gainItem(1061183, 1);
                    }
                    cm.gainItem(1003314, 1);
                    cm.gainItem(1072577, 1);
                    cm.gainItem(1082359, 1);
                    
                    cm.gainItem(1472152, 1);
                    break;
                    
                case 430:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040172, 1);
                        cm.gainItem(1060160, 1);
                    } else {
                        cm.gainItem(1041174, 1);
                        cm.gainItem(1061183, 1);
                    }
                    cm.gainItem(1003314, 1);
                    cm.gainItem(1072577, 1);
                    cm.gainItem(1082359, 1);
                    
                    
                    break;
                case 2400:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040172, 1);
                        cm.gainItem(1060160, 1);
                    } else {
                        cm.gainItem(1041174, 1);
                        cm.gainItem(1061183, 1);
                    }
                    cm.gainItem(1003314, 1);
                    cm.gainItem(1072577, 1);
                    cm.gainItem(1082359, 1);
                    
                    cm.gainItem(1362049, 1);
                    break;
                case 500:
		case 2500:
                case 1500:
                    cm.gainItem(1003315, 1);
                    cm.gainItem(1052392, 1);
                    cm.gainItem(1072578, 1);
                    cm.gainItem(1082360, 1);
                    cm.gainItem(1482113, 1);
                    cm.gainItem(1492112, 1);
                    break;
                case 3500:
                    cm.gainItem(1003315, 1);
                    cm.gainItem(1052392, 1);
                    cm.gainItem(1072578, 1);
                    cm.gainItem(1082360, 1);
                    cm.gainItem(1492112, 1);
                    break;
                case 501:
                    cm.gainItem(1003315, 1);
                    cm.gainItem(1052392, 1);
                    cm.gainItem(1072578, 1);
                    cm.gainItem(1082360, 1);
                    cm.gainItem(1532048, 1);
                    break;
                case 6100:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040170, 1);
                        cm.gainItem(1060159, 1);
                    } else {
                        cm.gainItem(1041172, 1);
                        cm.gainItem(1061182, 1);

                    }
                    cm.gainItem(1003312, 1);
                    cm.gainItem(1072574, 1);
                    cm.gainItem(1082356, 1); 
                    cm.gainItem(1092098, 1);
                    cm.gainItem(1402008, 1);
                    break;
                case 6500:
                    cm.gainItem(1003315, 1);
                    cm.gainItem(1052392, 1);
                    cm.gainItem(1072578, 1);
                    cm.gainItem(1082360, 1);
		    break;
                case 2700:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1050197, 1);
                        cm.gainItem(1060156, 1);
                    } else {
                        cm.gainItem(1041175, 1);
                        cm.gainItem(1061184, 1);
                    }
                    cm.gainItem(1072575, 1);
                    cm.gainItem(1082357, 1);
		    break;
                default:
                    cm.sendOk("장비를 지급받을 수 있는 직업단계가 아닙니다. 전직이 가능한 레벨인 경우, 전직을 하신 후 장비를 받을 수 있습니다.");
                    cm.dispose();
                    return;
                    
            }
	    cm.gainItem(2430446,-1);
	    cm.dispose();
        }
    }
}
