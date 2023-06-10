importPackage(java.text);

var seld = -1;
var stage = 0;
var item = 0;
var count = 1;
var expRate = 1;

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
    txt = "수고했어! 생각보다 대단한 실력을 가졌는걸?\r\n\r\n";
    if (cm.getPlayer().getFrittoEgg() != null) {
      txt += "#b#L1#드래곤의 알 훔치기 보상 받기#l\r\n";
    }
    if (cm.getPlayer().getFrittoEagle() != null) {
      txt += "#b#L2#독수리 사냥 보상 받기#l\r\n";
    }
    if (cm.getPlayer().getFrittoDancing() != null) {
      txt += "#b#L3#구애의 춤 보상 받기#l\r\n";
    }
    txt += "#b#L4#원래 왔던 곳으로 돌려보내줘.";
    cm.sendSimple(txt);
  } else if (status == 1) {
    seld = sel;
    if (cm.getPlayer().getInventory(2).isFull()) {
      cm.sendOk("소비창에 공간이 부족해. 1칸 이상 비우고 다시 말을 걸어줄래?");
      cm.dispose();
      return;
    }
    switch (seld) {
      case 1:
        stage = cm.getPlayer().getKeyValue(15042, "Stage");
        cm.getPlayer().setKeyValue(15042, "Stage", "0");
        cm.getPlayer().setFrittoEgg(null);
        cm.sendNextNoESC("휴~ 큰일 날 뻔 했군! 하마터면 #b드래곤#k에게 걸릴 뻔 했어!\r\n살금살금 올라가는 너의 모습을 보니 너도 나처럼 훌륭한 현상금 사냥꾼이 될 것 같더군 하핫!");
        break;
      case 2:
        stage = cm.getPlayer().getKeyValue(15141, "point");
        cm.getPlayer().setKeyValue(15141, "point", "0");
        cm.getPlayer().setFrittoEagle(null);
        cm.sendNextNoESC("하하! #b독수리 사냥#k은 어땠어?\r\n멀리서 총으로 쏘아 잡으니 생각보다 쉽지?");
        break;
      case 3: // 대사 불확실
        stage = cm.getPlayer().getKeyValue(15143, "score");
        cm.getPlayer().setKeyValue(15143, "score", "0");
        cm.getPlayer().setFrittoDancing(null);
        cm.sendNextNoESC("휴~ 큰일 날 뻔 했군! 하마터면 #b양치기#k에게 걸릴 뻔 했어!\r\n열심히 춤을 추는 모습을 보니 너도 나처럼 훌륭한 현상금 사냥꾼이 될 것 같더군 하핫!");
        break;
      case 4:
        cm.sendYesNo("정말 보상을 받지 않고 그냥 돌아가겠어?");
        break;
    }
  } else if (status == 2) {
    // https://strategywiki.org/wiki/MapleStory/Bounty_Hunt#Dragon_Egg_Steal
    switch (seld) {
      case 1: {
        switch (stage) {
          case 0:
            {
              item = 2434633;
              count = 1
              expRate = 240;
              break;
            }
          case 1:
            {
              item = 2434634;
              count = 1;
              expRate = 480;
              break;
            }
          case 2:
            {
              item = 2434634;
              count = 2;
              expRate = 720;
              break;
            }
          case 3:
            {
              item = 2434635;
              count = 1;
              expRate = 1200;
              break;
            }
          case 4:
            {
              item = 2434635;
              count = 2;
              expRate = 1680;
              break;
            }
          case 5:
            {
              item = 2434636;
              count = 1;
              expRate = 2000;
              break;
            }
          case 6:
            {
              item = 2434636;
              count = 2;
              expRate = 2400;
              break;
            }
          default:
            item = 2434633;
            count = 1;
            expRate = 1;
            break;
        }
        cm.sendNextNoESC("이번에는 #b#e" + stage + "#n#k단계 까지 올라갔군?\r\n자 여기 너의 몫으로#i" + item + ":# #b#t" + item + "##k와 #b경험치#k를 줄게 다음에 또 보자고!");
        break;
      }
      case 2:
        {
          item = 2434633;

          count = 0;

          expRate = 0;

          stage = parseInt(stage, 10);

          if (stage >= 50 && stage <= 300) {
            item = 2434633;

            count = 1;

            expRate = 240;
          } else if (stage <= 600) {
            item = 2434634;

            count = 1;

            expRate = 480;
          } else if (stage <= 950) {
            item = 2434635;

            count = 1;

            expRate = 720;
          } else if (stage === 1000) {
            item = 2434636;

            count = 2;

            expRate = 1200;
          }
          cm.sendNextNoESC("이번에는 #b#e" + stage + "#n#k단계 까지 올라갔군?\r\n자 여기 너의 몫으로#i" + item + ":# #b#t" + item + "##k와 #b경험치#k를 줄게 다음에 또 보자고!");
          break;
        }
      case 3:
        {
          // https://strategywiki.org/wiki/MapleStory/Bounty_Hunt#Courtship_Dance
          switch (stage) {
            case 1:
            case 2:
              {
                item = 2434633;
                count = 1
                expRate = 240;
                break;
              }
            case 3:
            case 4:
            case 5:
              {
                item = 2434634;
                count = 1;
                expRate = 480;
                break;
              }
            case 6:
            case 7:
              {
                item = 2434635;
                count = 1;
                expRate = 720;
                break;
              }
            case 8:
            case 9:
              {
                item = 2434636;
                count = 1;
                expRate = 960;
                break;
              }
            case 10:
              {
                item = 2434636;
                count = 2;
                expRate = 1200;
                break;
              }
            default:
              item = 2434633;
              count = 1;
              expRate = 1;
              break;
          }
          cm.sendNextNoESC("이번에는 #b#e" + stage + "#n#k번 성공했군?\r\n자 여기 너의 몫으로#i" + item + ":# #b#t" + item + "##k와 #b경험치#k를 줄게 다음에 또 보자고!");
          break;
        }
      case 4:
        cm.getPlayer().setFrittoEgg(null);
        cm.getPlayer().setFrittoEagle(null);
        cm.getPlayer().setFrittoDancing(null);
        var returnMap = parseInt(cm.getPlayer().getV("poloFrittoReturnMap"), 10);
        cm.getPlayer().addKV("flameWolfReturnMap", "");
        cm.getPlayer().addKV("poloFrittoReturnMap", "");
        cm.warp(returnMap);
        cm.dispose();
        break;
    }
  } else if (status == 3) {
    cm.dispose();
    if (count > 0) {
      cm.gainItem(item, count);
    }
    if (expRate > 0) {
      cm.addPoloAndFrittoExp(expRate)
    }
    var returnMap = parseInt(cm.getPlayer().getV("poloFrittoReturnMap"), 10);
    cm.getPlayer().addKV("flameWolfReturnMap", "");
    cm.getPlayer().addKV("poloFrittoReturnMap", "");
    cm.warp(returnMap);
  }
}