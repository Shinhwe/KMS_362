importPackage(Packages.server.life);
function enter(pi) {
    var map = pi.getPlayer().getMap();
    if (map.getReactor(2408003).getState() <= 0) {
        var pos = map.getReactor(2408003).getPosition();
        var mob = null;
        if (isChaos(pi) == 0) {
            mob = MapleLifeProvider.getMonster(8810024);
        } else {
            mob = MapleLifeProvider.getMonster(8810128);
        }
        pi.getPlayer().getMap().spawnMonsterOnGroundBelow(mob, pos);
        map.getReactor(2408003).設置潛能等級(1);
    }
    return false;
}


function isChaos(pi) {
    return pi.getClient().getChannel() % 2;
}
