/*
 * 퓨어온라인 소스 스크립트 입니다.
 * 
 * 포탈위치 : 
 * 포탈설명 : 
 * 
 * 제작 : 주크블랙
 * 
 */

function enter(pi) {
    pi.warp(pi.getSavedLocation("FREE_MARKET_SHOP"));
    pi.clearSavedLocation("FREE_MARKET_SHOP");
    return false;
}
