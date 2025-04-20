importPackage(java.text);

var enter = "\r\n";

var isFlameWolfKiller = false;

var item = 0;

var expRate = 0;

var level = 0;

var itemId = 0;

var itemCount = 0;

var damageText = '';

var flameWolfDamage = 0;

function start() {
    status = -1;
    action(1, 0, 0);
}

function action(mode, type, sel) {
    sel = +sel;
    if (mode == 1) {
        status++;
    } else {
        cm.dispose();
        return;
    }
    if (status == 0) {
        isFlameWolfKiller = cm.getPlayer().getIsFlameWolfKiller();
        var isHunting = !!cm.getPlayer().getV("poloFrittoReturnMap") === true;
        level = cm.getPlayer().getLevel();
        flameWolfDamage = cm.getPlayer().getFlameWolfDamage();
        if (isHunting) {
            cm.sendSimpleS("辛苦了, 這次也順利地完成了狩獵!, " + enter + "#b#L1#請送我回到原來的地方", 1);
        } else if (isFlameWolfKiller) {
            if (level < 200) {
                expRate = 800
            } else if (level < 260) {
                expRate = 1300
            } else {
                expRate = 1700
            }
            itemId = 2434636;
            itemCount = 2;
            cm.sendSimpleS("辛苦了, 你 #r#e擊敗#k#n 了火焰狼, 請收下我為你準備的豐厚獎勵!" + enter + "#b#L2#請送我回到原來的地方", 1);
        }
        else if (flameWolfDamage >= 1) {
            var faleWolfReward = JSON.parse(cm.calcFlameWolfExpReward());
            expRate = faleWolfReward.expRate;
            itemId = faleWolfReward.itemId;
            itemCount = faleWolfReward.itemCount;
            damageText = faleWolfReward.damageText;
            cm.sendSimpleS("辛苦了, 你對火焰狼造成了 #r#e" + damageText + "#k#n 的傷害, 請收下我為你準備的豐厚獎勵!" + enter + "#b#L3#請送我回到原來的地方", 1);
        } else {
            expRate = 0;
            itemId = 0;
            itemCount = 0;
            cm.sendSimpleS("辛苦了, 你沒有對火焰狼造成 #r#e任何#k#n 傷害!" + enter + "#b#L4#請送我回到原來的地方", 1);
        }
    } else if (status == 1) {
        if (sel === 1) {
            if (cm.getPlayer().getQuestStatus(16406) == 1) {
                quest = cm.getPlayer().getQuestNAdd(Packages.server.quest.MapleQuest.getInstance(16406));
                if (quest != null) {
                    cm.getPlayer().updateQuest(quest, true);
                }
            }
            var map = parseInt(cm.getPlayer().getV("poloFrittoReturnMap"), 10);
            cm.getPlayer().addKV("flameWolfReturnMap", "");
            cm.getPlayer().addKV("poloFrittoReturnMap", "");
            cm.warp(map);
            cm.getPlayer().setBountyHunting(null);
            cm.getPlayer().setDefenseTowerWave(null);
            cm.dispose();
            return;
        } else {
            // https://strategywiki.org/wiki/MapleStory/Bounty_Hunt#Flame_Wolf 
            if (itemCount > 0) {
                cm.gainItem(itemId, itemCount);
            }

            if (expRate > 0) {
                cm.addFlameWolfExp(expRate)
            }

            var map = parseInt(cm.getPlayer().getV("flameWolfReturnMap"), 10);
            cm.getPlayer().addKV("flameWolfReturnMap", "");
            cm.getPlayer().addKV("poloFrittoReturnMap", "");
            cm.warp(map);
            cm.getPlayer().setBountyHunting(null);
            cm.getPlayer().setDefenseTowerWave(null);
            cm.getPlayer().setFlameWolfAttackCount(0);
            cm.getPlayer().setIsFlameWolfKiller(false);
            cm.getPlayer().setFlameWolfDamage(0);
            cm.getPlayer().setFlameWolf(null);
            cm.dispose();
            return;
        }
    }
}
