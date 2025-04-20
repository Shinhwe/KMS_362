
/*

     [ PlatinumMS ]

     이 스크립트는 PlatinumMS 에서 제작한 스크립트 입니다.

     스크립트 용도 : 40레벨 장비상자

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
                case 110:
                case 120:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040177, 1);
                        cm.gainItem(1060165, 1);
                    } else {
                        cm.gainItem(1041180, 1);
                        cm.gainItem(1061189, 1);

                    }
                    cm.gainItem(1003326, 1);
                    cm.gainItem(1072589, 1);
                    cm.gainItem(1082371, 1); 
                    cm.gainItem(1092101, 1);
                    
                    cm.gainItem(1302188, 1);
                    break;
                case 130:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040177, 1);
                        cm.gainItem(1060165, 1);
                    } else {
                        cm.gainItem(1041180, 1);
                        cm.gainItem(1061189, 1);

                    }
                    cm.gainItem(1003326, 1);
                    cm.gainItem(1072589, 1);
                    cm.gainItem(1082371, 1); 
                    cm.gainItem(1092101, 1);
                    
                    cm.gainItem(1432112, 1);
                    break;
                case 1110:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040177, 1);
                        cm.gainItem(1060165, 1);
                    } else {
                        cm.gainItem(1041180, 1);
                        cm.gainItem(1061189, 1);

                    }
                    cm.gainItem(1003326, 1);
                    cm.gainItem(1072589, 1);
                    cm.gainItem(1082371, 1); 
                    cm.gainItem(1092101, 1);
                    
                    cm.gainItem(1302188, 1);
                    break;
                case 2110:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040177, 1);
                        cm.gainItem(1060165, 1);
                    } else {
                        cm.gainItem(1041180, 1);
                        cm.gainItem(1061189, 1);

                    }
                    cm.gainItem(1003326, 1);
                    cm.gainItem(1072589, 1);
                    cm.gainItem(1082371, 1); 
                    cm.gainItem(1092101, 1);
                    
                    cm.gainItem(1442150, 1);
                    break;
                case 3110:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040177, 1);
                        cm.gainItem(1060165, 1);
                    } else {
                        cm.gainItem(1041180, 1);
                        cm.gainItem(1061189, 1);

                    }
                    cm.gainItem(1003326, 1);
                    cm.gainItem(1072589, 1);
                    cm.gainItem(1082371, 1); 
                    cm.gainItem(1092101, 1);
                    
                    cm.gainItem(1322118, 1);
                    break;
                case 5110:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040177, 1);
                        cm.gainItem(1060165, 1);
                    } else {
                        cm.gainItem(1041180, 1);
                        cm.gainItem(1061189, 1);

                    }
                    cm.gainItem(1003326, 1);
                    cm.gainItem(1072589, 1);
                    cm.gainItem(1082371, 1); 
                    cm.gainItem(1092101, 1);
                    
                    cm.gainItem(1302188, 1);
                    break;
                case 210:
                case 220:
                case 230:
                case 1210:
                case 2212:
                case 3210:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1050201, 1);
//                        cm.gainItem(1060156, 1);
                    } else {
                        cm.gainItem(1051245, 1);
//                        cm.gainItem(1061184, 1);
                    }
                    cm.gainItem(1003327, 1);
                    cm.gainItem(1072590, 1);
                    cm.gainItem(1082372, 1);
                    cm.gainItem(1382138, 1);
                    break;
                case 310:
                case 1310:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040178, 1);
                        cm.gainItem(1060166, 1);
                    } else {
                        cm.gainItem(1041181, 1);
                        cm.gainItem(1061190, 1);
                    }
                    cm.gainItem(1003328, 1);
                    cm.gainItem(1072591, 1);
                    cm.gainItem(1082373, 1);
                    cm.gainItem(1452143, 1);
                    break;
                case 320:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040178, 1);
                        cm.gainItem(1060166, 1);
                    } else {
                        cm.gainItem(1041181, 1);
                        cm.gainItem(1061190, 1);
                    }
                    cm.gainItem(1003328, 1);
                    cm.gainItem(1072591, 1);
                    cm.gainItem(1082373, 1);
                    cm.gainItem(1462131, 1);
                    break;
                case 2310:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040178, 1);
                        cm.gainItem(1060166, 1);
                    } else {
                        cm.gainItem(1041181, 1);
                        cm.gainItem(1061190, 1);
                    }
                    cm.gainItem(1003328, 1);
                    cm.gainItem(1072591, 1);
                    cm.gainItem(1082373, 1);
                    cm.gainItem(1522034, 1);
                    break;
                case 3310:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040178, 1);
                        cm.gainItem(1060166, 1);
                    } else {
                        cm.gainItem(1041181, 1);
                        cm.gainItem(1061190, 1);
                    }
                    cm.gainItem(1003328, 1);
                    cm.gainItem(1072591, 1);
                    cm.gainItem(1082373, 1);
                    cm.gainItem(1462131, 1);
                    break;
                case 410:
                case 420:
                case 1410:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040179, 1);
                        cm.gainItem(1060167, 1);
                    } else {
                        cm.gainItem(1041182, 1);
                        cm.gainItem(1061191, 1);
                    }
                    cm.gainItem(1003329, 1);
                    cm.gainItem(1072592, 1);
                    cm.gainItem(1082374, 1);
                    
                    cm.gainItem(1472155, 1);
                    cm.gainItem(1332164, 1);
                    break;
                    
                case 431:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040179, 1);
                        cm.gainItem(1060167, 1);
                    } else {
                        cm.gainItem(1041182, 1);
                        cm.gainItem(1061191, 1);
                    }
                    cm.gainItem(1003329, 1);
                    cm.gainItem(1072592, 1);
                    cm.gainItem(1082374, 1);
                    
                    cm.gainItem(1332164, 1);
                    cm.gainItem(1342049, 1);
                    
                    break;
                case 2410:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040179, 1);
                        cm.gainItem(1060167, 1);
                    } else {
                        cm.gainItem(1041182, 1);
                        cm.gainItem(1061191, 1);
                    }
                    cm.gainItem(1003329, 1);
                    cm.gainItem(1072592, 1);
                    cm.gainItem(1082374, 1);
                    
                    cm.gainItem(1362052, 1);
                    break;
                case 510:
		case 2510:
                case 520:
                case 1510:
                    cm.gainItem(1003330, 1);
                    cm.gainItem(1052395, 1);
                    cm.gainItem(1072593, 1);
                    cm.gainItem(1082375, 1);
                    cm.gainItem(1482116, 1);
                    cm.gainItem(1492115, 1);
                    break;
                case 3510:
                    cm.gainItem(1003330, 1);
                    cm.gainItem(1052395, 1);
                    cm.gainItem(1072593, 1);
                    cm.gainItem(1082375, 1);
                    cm.gainItem(1492115, 1);
                    break;
                case 530:
                    cm.gainItem(1003330, 1);
                    cm.gainItem(1052395, 1);
                    cm.gainItem(1072593, 1);
                    cm.gainItem(1082375, 1);
                    cm.gainItem(1532051, 1);
                    break;
                case 6110:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040177, 1);
                        cm.gainItem(1060165, 1);
                    } else {
                        cm.gainItem(1041180, 1);
                        cm.gainItem(1061189, 1);

                    }
                    cm.gainItem(1003326, 1);
                    cm.gainItem(1072589, 1);
                    cm.gainItem(1082371, 1); 
                    cm.gainItem(1402007, 1);
                    break;
                case 6510:
                    cm.gainItem(1003330, 1);
                    cm.gainItem(1052395, 1);
                    cm.gainItem(1072593, 1);
                    cm.gainItem(1082375, 1);
		    break;
                case 2710:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1050201, 1);
                        cm.gainItem(1060156, 1);
                    } else {
                        cm.gainItem(1051245, 1);
                        cm.gainItem(1061184, 1);
                    }
                    cm.gainItem(1003327, 1);
                    cm.gainItem(1072590, 1);
                    cm.gainItem(1082372, 1);
                    break;
                default:
                    cm.sendOk("장비를 지급받을 수 있는 직업단계가 아닙니다. 전직이 가능한 레벨인 경우, 전직을 하신 후 장비를 받을 수 있습니다.");
                    cm.dispose();
                    return;
                    
            }
	    cm.gainItem(2430449,-1);
	    cm.dispose();
        }
    }
}
