// 
// Decompiled by Procyon v0.5.36
// 

package handling;

import constants.ServerConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public enum SendPacketOpcode implements WritableIntValueHolder
{
  PING,
  HACKSHIELD,
  SHOW_SOUL_EFFECT,
  WHITE_BACKGROUND_LODING,
  HOTFIX,
  DEBUG_CLIENT,
  SESSION_CHECK,
  SECONDPW_ERROR,
  INIT_SECURITY,
  UPDATE_SECURITY,
  GREEN_SHOW_INFO,
  BLIZZARD_TEMPEST,
  SAVE_PASSWORD,
  CHAR_END_REQUEST,
  LOGIN_STATUS,
  LEAVING_WORLD,
  SERVERLIST,
  SERVERSTATUS,
  CHECK_OTP,
  SERVER_IP,
  CHARLIST,
  TANGYOON_LIST,
  REEN_SHOW_INFO,
  CHAR_NAME_RESPONSE,
  ADD_NEW_CHAR_ENTRY,
  KAISER_CHANGE_COLOR,
  DELETE_CHAR_RESPONSE,
  ENABLE_RECOMMENDED,
  BLACK_MAGE_TAMPORARY_SKILL,
  SEND_RECOMMENDED,
  SELECT_CHANNEL_LIST,
  CHANGE_NAME_CHECK,
  CHANGE_NAME_RESPONSE,
  AUTH_STATUS_WITH_SPW,
  NEW_PASSWORD_CHECK,
  SKIP_NEW_PASSWORD_CHECK,
  AUTH_STATUS_WITH_SPW_RESULT,
  CHANGE_CHANNEL,
  SHOW_TITLE,
  UPDATE_STATS,
  UPDATE_ZERO_STATS,
  MEMORY_CHOICE,
  SKILL_USE_RESULT,
  UPDATE_ANGELIC_STATS,
  FAME_RESPONSE,
  OWL_RESULT,
  WEDDING_GIFT,
  UPDATE_SKILLS,
  POPUP_HOMEPAGE,
  TP_ADD,
  LIE_DETECTOR,
  LIE_DETECTOR_MULTI,
  REPORT_RESPONSE,
  REPORT_TIME,
  REPORT_STATUS,
  SHOW_MAGNIFYING_EFFECT,
  AP_RESET,
  BOAT_MOVE,
  MIRROR_DUNGEON_INFO,
  ANDROID_UPDATE,
  EXPAND_CHARACTER_SLOTS,
  WARP_TO_MAP,
  SERVERMESSAGE,
  ECHO_MESSAGE,
  AVATAR_MEGA,
  SPAWN_NPC,
  REMOVE_NPC,
  SPAWN_NPC_REQUEST_CONTROLLER,
  SPAWN_MONSTER,
  SPAWN_MONSTER_CONTROL,
  MOVE_MONSTER_RESPONSE,
  MONKEY_TOGETHER,
  CHATTEXT,
  SHOW_STATUS_INFO,
  SHOW_MESO_GAIN,
  SHOW_QUEST_COMPLETION,
  WHISPER,
  SPAWN_PLAYER,
  ANNOUNCE_PLAYER_SHOP,
  SHOW_SCROLL_EFFECT,
  SHOW_EFFECT,
  CURRENT_MAP_WARP,
  KILL_MONSTER,
  DROP_ITEM_FROM_MAPOBJECT,
  FACIAL_EXPRESSION,
  CHANGE_FACE_MOTION,
  MOVE_PLAYER,
  MONSTER_PROPERTIES,
  SMART_NOTICE,
  NAME_CHANGER,
  MOVE_MONSTER,
  CLOSE_RANGE_ATTACK,
  RANGED_ATTACK,
  MAGIC_ATTACK,
  BUFF_ATTACK,
  OPEN_NPC_SHOP,
  CONFIRM_SHOP_TRANSACTION,
  SHOP_INFO_RESET,
  OPEN_STORAGE,
  INVENTORY_OPERATION,
  REMOVE_PLAYER_FROM_MAP,
  REMOVE_ITEM_FROM_MAP,
  UPDATE_CHAR_LOOK,
  SHOW_FOREIGN_EFFECT,
  GIVE_FOREIGN_BUFF,
  CANCEL_FOREIGN_BUFF,
  DAMAGE_PLAYER,
  CHAR_INFO,
  UPDATE_QUEST_INFO,
  GIVE_BUFF,
  CANCEL_BUFF,
  PLAYER_INTERACTION,
  ZodiacInfo,
  ZodiacRankInfo,
  MAPLE_YUT,
  UPDATE_CHAR_BOX,
  NPC_TALK,
  KEYMAP,
  SHOW_MONSTER_HP,
  PARTY_OPERATION,
  UPDATE_PARTYMEMBER_HP,
  MULTICHAT,
  APPLY_MONSTER_STATUS,
  CANCEL_MONSTER_STATUS,
  CLOCK,
  SPAWN_PORTAL,
  PUNCH_KING,
  SPAWN_DOOR,
  REMOVE_DOOR,
  ULTIMATE_MATERIAL,
  SPAWN_SUMMON,
  REMOVE_SUMMON,
  SUMMON_ATTACK,
  MOVE_SUMMON,
  SPAWN_MIST,
  REMOVE_MIST,
  DAMAGE_SUMMON,
  HEAL_EFFECT_MONSTER,
  DAMAGE_MONSTER,
  BUDDYLIST,
  SHOW_ITEM_EFFECT,
  SHOW_CHAIR,
  RESULT_CHAIR,
  REQUIRE_CHAIR,
  INVITE_CHAIR,
  SPECIAL_CHAIR,
  CANCEL_CHAIR,
  SKILL_EFFECT,
  MANNEQUIN_RES,
  MANNEQUIN,
  CANCEL_SKILL_EFFECT,
  BOSS_ENV,
  REACTOR_SPAWN,
  REACTOR_HIT,
  REACTOR_DESTROY,
  MAP_EFFECT,
  GUILD_OPERATION,
  SEARCH_GUILD,
  ALLIANCE_OPERATION,
  EARN_TITLE_MSG,
  SHOW_MAGNET,
  MERCH_ITEM_MSG,
  MERCH_ITEM_STORE,
  MESSENGER,
  MESSENGER_SEARCH,
  NPC_ACTION,
  SPAWN_PET,
  MOVE_PET,
  PET_CHAT,
  PET_COMMAND,
  PET_NAMECHANGE,
  PET_AUTO_HP,
  PET_AUTO_MP,
  JAGUAR_AUTO_ATTACK,
  COOLDOWN,
  PLAYER_HINT,
  SUMMON_HINT,
  SUMMON_HINT_MSG,
  CYGNUS_INTRO_DISABLE_UI,
  CYGNUS_INTRO_LOCK,
  USE_SKILL_BOOK,
  SHOW_EQUIP_EFFECT,
  SKILL_MACRO,
  CS_OPEN,
  CS_UPDATE,
  CS_OPERATION,
  PLAYER_NPC,
  SHOW_NOTES,
  SUMMON_SKILL,
  SUMMON_DEBUFF,
  ARIANT_PQ_START,
  WONDER_BERRY,
  LUNA_CRYSTAL,
  CATCH_MONSTER,
  CATCH_MOB,
  CHALKBOARD,
  DUEY,
  TROCK_LOCATIONS,
  SPAWN_HIRED_MERCHANT,
  UPDATE_HIRED_MERCHANT,
  DESTROY_HIRED_MERCHANT,
  UPDATE_MOUNT,
  VICIOUS_HAMMER,
  FINISH_SORT,
  FINISH_GATHER,
  YELLOW_CHAT,
  LEVEL_UPDATE,
  MARRIAGE_UPDATE,
  JOB_UPDATE,
  HORNTAIL_SHRINE,
  STOP_CLOCK,
  DRAGON_MOVE,
  DRAGON_REMOVE,
  DRAGON_SPAWN,
  AranCombo,
  TOP_MSG,
  TEMP_STATS,
  TEMP_STATS_RESET,
  OPEN_UI,
  OPEN_UI_OPTION,
  SHOW_POTENTIAL_RESET,
  SHOW_REDCUBE_EFFECT,
  BLACK_CUBE_WINDOW,
  SHOW_BLACKCUBE_EFFECT,
  SHOW_ENCHANTER_EFFECT,
  SHOW_SOULSCROLL_EFFECT,
  CHAOS_ZAKUM_SHRINE,
  BOAT_EFF,
  OWL_OF_MINERVA,
  CASH_SONG,
  INVENTORY_GROW,
  SERPENT_MARK,
  TALK_MONSTER,
  REMOVE_TALK_MONSTER,
  MOVE_ENV,
  UPDATE_ENV,
  ENGAGE_REQUEST,
  ENGAGE_RESULT,
  UPDATE_JAGUAR,
  EXPEDITION_OPERATION,
  APPLY_STATUS_ATTACK,
  TESLA_TRIANGLE,
  MECH_PORTAL,
  MECH_DOOR_SPAWN,
  MECH_DOOR_REMOVE,
  PET_FLAG_CHANGE,
  PLAYER_DAMAGED,
  SP_RESET,
  REPORT,
  ULTIMATE_EXPLORER,
  CS_USE,
  COODINATION_RESULT,
  HARVESTED,
  SHOW_HARVEST,
  GAME_MESSAGE,
  SPAWN_EXTRACTOR,
  REMOVE_EXTRACTOR,
  HARVEST_MESSAGE,
  OPEN_BAG,
  MID_MSG,
  NPC_SCRIPTABLE,
  ANDROID_SPAWN,
  ANDROID_MOVE,
  ANDROID_EMOTION,
  ANDROID_REMOVE,
  ANDROID_DEACTIVATED,
  PENDANT_SLOT,
  PARTY_SEARCH,
  MEMBER_SEARCH,
  AranCombo_RECHARGE,
  LOAD_GUILD_NAME,
  LOAD_GUILD_ICON,
  UPDATE_GENDER,
  UPDATE_DAMAGE_SKIN,
  ACHIEVEMENT_RATIO,
  CREATE_ULTIMATE,
  SPECIAL_STAT,
  CLEAR_MID_MSG,
  DOTGE,
  PLAY_MOVIE,
  DETAIL_SHOW_INFO,
  DIRECTION_INFO,
  DIRECTION_STATUS,
  RAINBOW_RUSH,
  CREATE_FORCE_ATOM,
  REMOVE_FORCE_ATOM,
  CYGNUS_INTRO_ENABLE_UI,
  PET_LOOT_STATUS,
  PET_EXCEPTION_LIST,
  MERCHANT_NAME_CHANGE,
  ENABLE_INNER_ABILITY,
  UPDATE_HONOR,
  POPUP_MSG,
  EVENT_SKILL_EFFECT,
  SKILL_FROM_MONSTER_EFFECT,
  EVENT_SKILL_START,
  EVENT_SKILL_END,
  EVENT_SKILL_SET,
  HEAD_TITLE,
  MAPLE_EXIT,
  AUCTION,
  AUCTION_BUY,
  INTERNET_CAFE,
  BEGIN_RANDOMPORTALPOOL,
  RandomPortalTryEnterRequest,
  RandomPortalRemoved,
  RESPAWN_RUNE,
  SPAWN_RUNE,
  REMOVE_RUNE,
  RUNE_ACTION,
  RUNE_EFFECT,
  ZERO_MUlTITAG,
  ZERO_SCROLL,
  ZERO_SCROLL_SEND,
  ZERO_SCROLL_START,
  ZERO_WEAPON_INFO,
  ZERO_WEAPON_UPGRADE,
  ZERO_SHOCKWAVE,
  ZERO_TAG,
  CHAR_NAME_CHANGE,
  SPAWN_ARROW_FLATTER,
  ACITVE_ARROW,
  REMOVE_ARROW_FLATTER,
  FlipTheCoin,
  REPLACE_SKILLS,
  UPDATE_STOLEN_SKILLS,
  TARGET_SKILL,
  PHANTOM_CARD,
  SHOW_VOYD_PRESSURE,
  THE_SEED_ITEM,
  SHOW_DAMAGE_SKIN,
  UPDATE_DRESS,
  LUMINOUS_MORPH,
  EQUIPMENT_ENCHANT,
  LOCK_SKILL,
  LOG_OUT,
  OTP_CHANGE,
  FieldWeather_Add,
  FieldWeather_Remove,
  BlockGameControl,
  BlockGameCommand,
  FROZEN_LINK,
  UserMesoChairAddMeso,
  UserTowerChairSettingResult,
  SPECIAL_MAP_EFFECT,
  STARDUST_UI,
  STARDUST_INCREASE,
  EnterBingoGame,
  HostNumber,
  HostNumberReady,
  AddBingoRank,
  CheckNumberAck,
  BingoGameState,
  YELLOW_DLG,
  BEGIN_FIELD_HUNDREDOXQUIZ,
  HOxQuizEnter,
  HOxQuizQuestions,
  HOxQuizExplan,
  HOxQuizCountEffect,
  HOxQuizMoveToPortal,
  HOxQuizResult,
  DREAM_BREAKER_RANKING,
  DREAM_BREAKER,
  HDetectiveGamePlainText,
  HDetectiveGameCommand,
  HDetectiveGameSetGame,
  HDetectiveGameAddRank,
  HDetectiveGameResult,
  HDetectiveGameClear,
  SHOW_WEB,
  UserClientResolutionRequest,
  UserTimerInfo,
  CLEAR_OBSTACLE,
  CameraCtrlMsg,
  SetInGameDirectionMode,
  SetStandAloneMode,
  UserInGameDirectionEvent,
  PlayAmbientSound,
  StopAmbientSound,
  NpcSpecialAction,
  NpcSpecialAction2,
  NpcSpecialAction3,
  NpcSpecialAction4,
  TIME_CAPSULE,
  MATRIX_WINDOW,
  NETT_PYRAMID_WAVE,
  NETT_PYRAMID_LIFE,
  NETT_PYRAMID_POINT,
  NETT_PYRAMID_CLEAR,
  IMAGE_NPC_TALK,
  FLOW_OF_FIGHT,
  SUCCESS_LOGIN,
  SKILL_ATTACK_EFFECT,
  SPAWN_ORB,
  REMOVE_ORB,
  MOVE_ORB,
  FULL_MAKER,
  CREATE_SPECIAL_PORTAL,
  REMOVE_SPECIAL_PORTAL,
  EGO_WEAPON,
  CHECK_LOGIN,
  UNLOCK_SKILL, HYPER_PRESET,
  HYPER,
  BIND_MONSTER,
  CORE_LIST,
  ADD_CORE,
  ENFORCE_CORE,
  PSYCHIC_GREP,
  PSYCHIC_ULTIMATE,
  PSYCHIC_DAMAGE,
  PSYCHIC_ATTACK,
  CANCEL_PSYCHIC_GREP,
  MATRIX_SKILL,
  MATRIX_SKILL2,
  SET_DEAD,
  BIND_SKILL,
  UNLINK_SKILL,
  UNLINK_SKILL_UNLOCK,
  LINK_SKILL,
  SHOW_EDITIONALCUBE_EFFECT,
  BLACKMAGE_DEATHCOUNT,
  DEATH_COUNT,
  SET_DEATH_COUNT,
  SHOW_DEATH_COUNT,
  OPEN_UI_DEAD,
  SET_MONSTER_AFTER_ATTACK,
  MONSTER_AFTER_ATTACK_ONE,
  LUCID2_WELCOME_BARRAGE,
  LUCID_BUTTERFLY_ACTION,
  LUCID_DRAGON_CREATE,
  LUCID_DO_SKILL,
  LUCID2_STAINED_GLASS_ON_OFF,
  LUCID2_SET_FLYING_MODE,
  LUCID_STATUE_STATE_CHANGE,
  LUCID2_STAINED_GLASS_BREAK,
  LUCID_BUTTERFLY_CREATE,
  SHOW_SOULEFFECT_RESPONSE,
  ENTER_AUCTION,
  SHOW_CUBE_EFFECT,
  DAILY_GIFT,
  ALARM_AUCTION,
  MOMENT_AREA_ON_OFF_ALL,
  USER_TELEPORT,
  RESPAWN,
  SPAWN_MAHA,
  SPAWN_FIELDATTACK_OBJ,
  FIELDATTACK_OBJ_ATTACK,
  REMOVE_FIELDATTACK_OBJ_KEY,
  REMOVE_FIELDATTACK_OBJ_LIST,
  CHANGE_PHASE,
  CHANGE_MOBZONE,
  CHANNEL_BACK_IMG,
  SOUL_MATCHING,
  CLOSE_UI,
  KEEP_DRESSUP,
  DROP_STONE,
  SHOW_PIERRE_EFFECT,
  BLOCK_ATTACK,
  TELEPORT_MONSTER,
  SHADOW_SERVENT_EXTEND,
  HAMMER_OF_TODD,
  CREATE_OBSTACLE,
  DEBUFF_OBJECT,
  OPEN_UNION,
  HAKU_SPAWN,
  HAKU_MOVE,
  BEHOLDER_REVENGE,
  ENABLE_LOGIN,
  FINAL_ATTACK_REQUEST,
  DEATH_ATTACK,
  ROYAL_DAMAGE,
  CHAINARTS_CHASE,
  BONUS_ATTACK_REQUEST,
  ENTER_FIELD_PSYCHIC_INFO,
  CHATTEXTITEM,
  UPDATE_SUMMON,
  ENFORCE_MSG,
  MOBSKILL_DELAY,
  SPAWN_SUB_SUMMON,
  JAGUAR_ATTACK,
  AIR_ATTACK,
  ZERO_MUlTITAG_REMOVE,
  B2BODY_RESULT,
  MATRIX_MULTI,
  LIGHTING_ATTACK,
  GRAND_CROSS,
  COMBO_INSTICT,
  SHOW_PROJECTILE_EFFECT,
  BLACKJACK,
  RANGE_ATTACK,
  CREATE_MAGIC_WRECK,
  REMOVE_MAGIC_WRECK,
  ENERGY_SPHERE,
  FORCE_ATOM_ATTACK,
  FLYING_SWORD_CREATE,
  STIGMA_INCINERATE_OBJECT,
  FLYING_SWORD_NODE,
  FLYING_SWORD_TARGET,
  SCREEN_ATTACK,
  SPEAK_MONSTER,
  ZAKUM_ATTACK,
  VIEW_CORE,
  DELETE_CORE,
  MIRACLE_CIRCULATOR,
  HUGNRY_MUTO,
  CHAINARTS_FURY,
  ICBM,
  BOSS_REWARD,
  UNSTABLE_MEMORIZE,
  SPIRIT_FLOW,
  AIRBONE,
  WP_UPDATE,
  POISON_NOVA_MULTI,
  POISON_NOVA,
  WILL_CREATE_BULLETEYE,
  WILL_SET_MOONGAUGE,
  WILL_SET_HP,
  WILL_SPIDER_ATTACK,
  WILL_MOONGAUGE,
  WILL_SET_HP2,
  WILL_USE_SPECIAL,
  WILL_STUN,
  FORCE_ACTION,
  WILL_COOLTIME_MOONGAUGE,
  WILL_THIRD_ONE,
  WILL_SPIDER,
  WILL_TELEPORT,
  WILL_POISON,
  WILL_POISON_REMOVE,
  WILL_POISON_ATTACK,
  RUNE_CURSE,
  ELEMENTAL_RADIANCE,
  DAMAGE_SUMMON_2,
  SPECIAL_SUMMON,
  SUMMON_RANGE_ATTACK,
  SPECIAL_SUMMON2,
  TRANSFORM_SUMMON,
  RETURNEFFECT_CONFIRM,
  RETURNEFFECT_MODIFY,
  BUFF_FREEZER,
  DEMIAN_ATTACK_CREATE,
  IGNITION_BOMB,
  QUICK_SLOT,
  DIMENTION_MIRROR,
  QUICK_MOVE,
  MULTICHATITEM,
  WHITE_CUBE_WINDOW,
  ELITE_WARNING,
  MIX_LENSE,
  SET_UNION,
  UNION_FREESET,
  OPEN_CORE,
  FISHING,
  FISHING_RESULT,
  MOB_DROP_MESO_PICKUP,
  SESSION_VALUE,
  FIELD_SET_VARIABLE,
  QUICK_PASS,
  UPDATE_MAPLEPOINT,
  SELECTED_WORLD,
  SPECIAL_MAP_SOUND,
  BOUNTY_HUNTING,
  COURTSHIP_STATE,
  COURTSHIP_COMMAND,
  TOWER_DEFENSE_WAVE,
  TOWER_DEFENSE_LIFE,
  ARCANE_CATALYST,
  ARCANE_CATALYST2,
  RETURN_SYNTHESIZING,
  DEMIAN_RUNAWAY,
  FLYING_SWORD_MAKE_ENTER_REQUEST,
  STIGMA_TIME,
  DEMIAN_PHASE_CHANGE,
  CORRUPTION_CHANGE,
  USE_SKILL_WITH_UI,
  LUCID3_PHASE,
  TELEPORT_REQUEST,
  POTION_COOLDOWN,
  ACTIVE_POTION_COOL,
  BLACK_REBIRTH_SCROLL,
  JINHILLAH_BLACK_HAND,
  JIN_HILLAH,
  JINHILLAH_SPIRIT,
  CREATE_OBSTACLE2,
  DUSK_GAUGE,
  ENABLE_ONLYFSM_ATTACK,
  FIELD_SKILL,
  MONSTER_BARRIER,
  MONSTER_BARRIER_EFFECT,
  FIELD_SKILL_REMOVE,
  GOLD_APPLE,
  BLACK_REBIRTH_RESULT,
  REMOVE_PROJECTILE_EFFECT,
  UPDATE_PROJECTILE_EFFECT,
  SHOW_ICBM,
  FOLLOW_REQUEST,
  FOLLOW_EFFECT,
  FOLLOW_MOVE,
  FOLLOW_MSG,
  BATTLE_STATISTICS,
  UI_EVENT_INFO,
  SPAWN_PARTNER,
  UI_EVENT_SET,
  MONSTER_RESIST,
  PORTAL_TELEPORT,
  SPAWN_SECOND_ATOMS,
  REMOVE_SECOND_ATOM,
  UI_EVENT_INFO_SET,
  UNION_RAID_HP,
  UNION_RAID_SCORE,
  UNION_RAID_COIN,
  SCROLL_CHAT,
  REMOVE_PROJECTILE,
  MONSTER_PYRAMID,
  ENTER_FARM,
  SET_FARM_USER,
  FARM_SET_INGAME_INFO,
  FARM_REQ_SET_INGAME_INFO,
  FARM_NOTICE,
  FARM_IMG_UPDATE,
  PHOTO_RESULT,
  UPDATE_GUILD_SCORE,
  SHOW_GUILD_RANK,
  SET_GUN,
  SET_AMMO,
  CREATE_GUN,
  SHOOT_RESULT,
  CLEAR_GUN,
  DEAD_FPS_MODE,
  SHAPE_SHIFT,
  REFRESH_QUESTINFO,
  PSYCHIC_GREP_ATTACK,
  SPAWN_DIRECTION_OBJECT,
  EXPERT_THROW,
  NPC_ENFORCE_TALK,
  MONSTER_FORCE_MOVE,
  ATTACK_SECOND_ATOM,
  WRECK_ATTACK,
  SCATTERING_SHOT,
  DEATH_BLESS_STACK,
  DEATH_BLESS_ATTACK,
  FIRE_WORK,
  FIRE_BLINK,
  SHADOW_SPEAR_BIG,
  DAMAGE_PLAYER2,
  APPLY_LIGHT_OF_CURIGI,
  FALLING_TIME,
  BlizzardTempest,
  DRAGON_CHANGE,
  DRAGON_ATTACK,
  MECH_DOOR_COOLDOWN,
  NUJUK_MONSTER_DAMAGE,
  NUJUK_MONSTER_DAMAGE2,
  REBOLVING_BUNK,
  NOVILITY_SHILED,
  SPAWN_BULLET,
  EARLY_SKILL_ACTIVE,
  CRYSTAL_TELEPORT,
  ACCEPT_QUEST,
  NPC_MOVE_ACTION,
  NPC_CHANGE_ACTION,
  EVENT_SKILL_ON,
  COLOR_CARD_STATE,
  COLOR_CARD_MAIN,
  COLOR_CARD_RESULT,
  COLOR_CARD_SETTING,
  COLOR_CARD_SETTING1,
  COLOR_CARD_KIND,
  COLOR_CARD_SETTING2,
  COLOR_CARD_BONUS,
  CONTENTS_WAITING,
  SHOW_EFFECT2,
  BIG_WISP_HANDLER,
  BIG_WISP_RANK,
  BIG_WISP_INFO_PUT,
  BIG_WISP_PATTERN_CHANGE,
  ACTIVE_UNICON,
  NPC_MOTION,
  CHARACTER_LOAD,
  BATTLE_GROUND_ATTACK,
  BATTLE_GROUND_MOVE_ATTACK,
  BATTLE_GROUND_COOLDOWN,
  BATTLE_GROUND_ATTACK_REFRESH,
  BATTLE_GROUND_ATTACK_DAMAGE,
  BATTLE_GROUND_CHANGE_AVATER,
  BATTLE_GROUND_UPDATE_AVATER,
  BATTLE_GROUND_AVATER_SKILL,
  BATTLE_GROUND_ATTACK_BONUS,
  BATTLE_GROUND_SKILLON,
  BATTLE_GROUND_TAKEDAMAGE,
  BATTLE_GROUND_EFFECT,
  BATTLEGROUND_UPGRADE_SKILL,
  BATTLEGROUND_UPGRADE_EFFECT,
  BATTLE_GROUND_SHOW_POINT,
  BATTLE_GROUND_DEATH,
  BATTLE_GROUND_DEATH_EFFECT,
  FUSION_ANVIL,
  ZAKUM_ARM_ATTACK,
  AGGRESSIVE,
  HILLA_HP_DRAIN_START,
  HILLA_HP_DRAIN_EFFECT,
  HILLA_HP_DRAIN_ACTIVE,
  PAPULATUS_HANDLE,
  PAPULATUS_SPECIAL_PATTEN,
  PRACTICE_MODE,
  STOP_VANVAN_BIND,
  LASER_HANDLE,
  ADD_STIGMA,
  DEMIAN_TRANSCENDENTAL_SET,
  DEMIAN_TRANSCENDENTAL_SET2,
  BOSS_MATCHING_CHANCE,
  REBIRTH_SCROLL_WINDOW,
  EXP_DROP_PENALTY,
  PENALTY_MSG,
  QUEST_MSG,
  SPRIT_PANDENT,
  MAPLE_CABINET,
  SEREN_BACKGROUND_CHANGE,
  SEREN_STUN_GAUGE,
  SEREN_MOB_LASER,
  SEREN_TIMER,
  SEREN_SPAWN_OTHER_MIST,
  SEREN_UNK,
  PLAY_SOUND,
  SEREN_CHANGE_PHASE,
  MONSTER_ATTACK,
  DESTORY_BACK_IMG,
  USE_SKILL,
  CREATE_SPEICAL_SUMMON,
  SPEICAL_SUMMON_ATTACK,
  SPEICAL_SUMMON_TELEPORT,
  UNION_COIN_MAX,
  SHOP_LIMIT,
  NPC_NAME_INVISIBLE,
  SPECIAL_MAP_EFFECT_SET,
  SPECIAL_MAP_EFFECT_CHANGE,
  EVENT_INFO_PUT,
  EVENT_SEND_MSG,
  FOLLOW_NPC_TO_SKILL,
  EVENT_SKILL_ON_FLOWER,
  BLOOMING_RACE,
  BLOOMING_RACE_ACHIEVE,
  BLOOMING_RACE_RANKING,
  FOOTHOLD_ON_OFF_EFFECT,
  FOOTHOLD_ON_OFF,
  EXP_POCKET,
  SET_FORCE_ATOM_TARGET,
  CHAT_EMOTICON,
  BATTLE_GROUND_SELECT_AVATER,
  BATTLE_GROUND_SELECT_AVATER_OTHER,
  BATTLE_GROUND_SELECT_AVATER_CLOCK,
  THUNDER_ATTACK,
  EQUIPMENT_ENCHANT_MESSAGE,
  CREATE_CORE,
  ERDA_SPECTRUM_SETTING,
  ERDA_SPECTRUM_TYPE,
  ERDA_SPECTRUM_GAUGE,
  ERDA_SPECTRUM_AREA,
  SP_PORTAL,
  USE_MAKEUP_COUPON,
  MONSTER_MULUG,
  MONSTER_MULUG1,
  ON_BOMB,
  DOJANG_RANK,
  MONSTER_NOTDAMGE,
  MONSTER_NOTDAMGE_EFFECT,
  CRAFT_EFFECT,
  CRAFT_COMPLETE,
  ITEMMAKER_COOLDOWN,
  PANGPANG_REACTION_READY,
  PANGPANG_REACTION_ACT,
  PANGPANG_REACTION_END,
  TYOONKITCHEN_HANDLE,
  TYOONKITCHEN_SETTING,
  TYOONKITCHEN_MENU,
  TYOONKITCHEN_EFFECT,
  TYOONKITCHEN_UNK,
  SHOW_ACTION_EFFECT,
  TELEPORT_PLAYER;
  
  static
  {
    reloadValues();
  }
  
  private short code;
  
  SendPacketOpcode()
  {
    this.code = -2;
  }
  
  public static Properties getDefaultProperties() throws IOException
  {
    final Properties props = new Properties();
    final FileInputStream fileInputStream = new FileInputStream("sendops.properties");
    props.load(fileInputStream);
    fileInputStream.close();
    return props;
  }
  
  public static final void reloadValues()
  {
    try
    {
      ExternalCodeTableGetter.populateValues(getDefaultProperties(), values());
    }
    catch (IOException e)
    {
      throw new RuntimeException("Failed to load sendops", e);
    }
  }
  
  public static String getOpcodeName(final int value)
  {
    for (final SendPacketOpcode opcode : values())
    {
      if (opcode.getValue() == value)
      {
        return opcode.name();
      }
    }
    return "UNKNOWN";
  }
  
  @Override
  public short getValue()
  {
    if (!ServerConstants.MAPLE_VERSION_IS_TEST)
    {
      return this.code;
    }
    if (this.code >= SendPacketOpcode.RETURNEFFECT_CONFIRM.code)
    {
      return (short) (this.code + 1);
    }
    return this.code;
  }
  
  @Override
  public void setValue(final short code)
  {
    this.code = code;
  }
}