importPackage(Packages.client);
importPackage(Packages.constants);
importPackage(Packages.server.maps);
importPackage(Packages.tools.packet);
importPackage(Packages.server);
importPackage(java.lang);
importPackage(java.util);

var outmap = 211070000;
var time = 0;

function init() {}

function setup(mapid) {
    var a = Randomizer.nextInt();
    map = parseInt(mapid);
    while (em.getInstance("Normal_VonBon" + a) != null) {
        a = Randomizer.nextInt();
    }
    var eim = em.newInstance("Normal_VonBon" + a);
    eim.setInstanceMap(map).resetFully();
    eim.setInstanceMap(map + 10).resetFully();
    return eim;
}

function playerEntry(eim, player) {
    eim.setProperty("stage","0")
    eim.startEventTimer(600000);
    var map = eim.getMapInstance(0);
    player.setDeathCount(5);
    player.changeMap(map, map.getPortal(0));
}

function spawnMonster(eim) {}

function playerRevive(eim, player) {
    return false;
}

function scheduledTimeout(eim) {
    end(eim);
}

function changedMap(eim, player, mapid) {
    if (mapid != 105200100 && mapid != 105200110 && mapid != 105200120) {
        player.setDeathCount(0);
        eim.unregisterPlayer(player);
        eim.disposeIfPlayerBelow(0, 0);
    }
}

function playerDisconnected(eim, player) {
    return 0;
}

function monsterValue(eim, mobId) {
    stage = parseInt(eim.getProperty("stage"));
    if (mobId == 8910100 && stage == 1) {
        eim.restartEventTimer(300000);
    }
    return 1;
}

function playerExit(eim, player) {
    eim.unregisterPlayer(player);
    eim.disposeIfPlayerBelow(0, 0);
}

function end(eim) {
    eim.disposeIfPlayerBelow(100, outmap);
}


function clearPQ(eim) {
    end(eim);
}


function disposeAll(eim) {
    var iter = eim.getPlayers().iterator();
    while (iter.hasNext()) {
        var pl = iter.next();
        eim.unregisterPlayer(pl);
        pl.changeMap(outmap, 0);
    }
    end(eim);
}

function allMonstersDead(eim) {
    //after ravana is dead nothing special should really happen
}

function leftParty(eim, player) {
    disposeAll(eim);
}

function disbandParty(eim) {
    disposeAll(eim);
}

function playerDead(eim, player) {}

function cancelSchedule() {}
