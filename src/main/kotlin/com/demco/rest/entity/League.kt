package com.demco.rest.entity

import com.demco.rest.dto.LeagueRequestDTO
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Leagues: IntIdTable("leagues") {
  val owner_id = integer("owner_id")
  val name =  varchar("name", 50)
  val qbs = integer("qbs")
  val rbs = integer("rbs")
  val wrs = integer("wrs")
  val tes = integer("tes")
  val flex = integer("flex")
  val kicker = integer("kicker")
  val def = integer("def")
  val pp_pass_yd = double("pp_pass_yd")
  val pp_pass_td = integer("pp_pass_td")
  val pp_pass_2pt = integer("pp_pass_2pt")
  val pp_pass_int = integer("pp_pass_int")
  val pp_pass_pick6 = integer("pp_pass_pick6")
  val pp_rush_yd = double("pp_rush_yd")
  val pp_rush_td = integer("pp_rush_td")
  val pp_rush_2pt = integer("pp_rush_2pt")
  val pp_rec_recep = double("pp_rec_recep")
  val pp_rec_yd = float("pp_rec_yd")
  val pp_rec_td = integer("pp_rec_td")
  val pp_rec_2pt = integer("pp_rec_2pt")
  val pp_fg_0_19 = integer("pp_fg_0_19")
  val pp_fg_20_29 = integer("pp_fg_20_29")
  val pp_fg_30_39 = integer("pp_fg_30_39")
  val pp_fg_40_49 = integer("pp_fg_40_49")
  val pp_fg_50 = integer("pp_fg_50")
  val pp_pat = integer("pp_pat")
  val pp_fg_missed = integer("pp_fg_missed")
  val fg_missed_max = integer("fg_missed_max")
  val pp_pat_missed = integer("pp_pat_missed")
  val pp_def_td = integer("pp_def_td")
  val pp_def_pts_allowed_0 = integer("pp_def_pts_allowed_0")
  val pp_def_pts_allowed_1_6 = integer("pp_def_pts_allowed_1_6")
  val pp_def_pts_allowed_7_13 = integer("pp_def_pts_allowed_7_13")
  val pp_def_pts_allowed_14_20 = integer("pp_def_pts_allowed_14_20")
  val pp_def_pts_allowed_21_27 = integer("pp_def_pts_allowed_21_27")
  val pp_def_pts_allowed_28_34 = integer("pp_def_pts_allowed_28_34")
  val pp_def_pts_allowed_35 = integer("pp_def_pts_allowed_35")
  val pp_def_4th_down_stop = integer("pp_def_4th_down_stop")
  val pp_def_sack = integer("pp_def_sack")
  val pp_def_interception = integer("pp_def_interception")
  val pp_def_fumble_recovery = integer("pp_def_fumble_recovery")
  val pp_def_safety = integer("pp_def_safety")
  val pp_def_forced_fumble = integer("pp_def_forced_fumble")
  val pp_def_blocked_kick = integer("pp_def_blocked_kick")
  val pp_spt_td = integer("pp_spt_td")
  val pp_spt_forced_fumble = integer("pp_spt_forced_fumble")
  val pp_spt_fumble_recovery = integer("pp_spt_fumble_recovery")
  val pp_fumble_td = integer("pp_fumble_td")
  val pp_fumble_lost = integer("pp_fumble_lost")
  val playoff_week = integer("playoff_week")

  fun create(league: LeagueRequestDTO): League =
    League.new {
      ownerId = league.ownerId
      name =  league.name
      qbs = league.qbs
      rbs = league.rbs
      wrs = league.wrs
      tes = league.tes
      flex = league.flex
      kicker = league.kicker
      def = league.def
      ppPassYd = league.ppPassYd
      ppPassTd = league.ppPassTd
      ppPass2pt = league.ppPass2pt
      ppPassInt = league.ppPassInt
      ppPassPick6 = league.ppPassPick6
      ppRushYd = league.ppRushYd
      ppRushTd = league.ppRushTd
      ppRush2pt = league.ppRush2pt
      ppRecRecep = league.ppRecRecep
      ppRecYd = league.ppRecYd
      ppRecTd = league.ppRecTd
      ppRec2pt = league.ppRec2pt
      ppFg0_19 = league.ppFg0_19
      ppFg20_29 = league.ppFg20_29
      ppFg30_39 = league.ppFg30_39
      ppFg40_49 = league.ppFg40_49
      ppFg_50 = league.ppFg_50
      ppPat = league.ppPat
      ppFgMissed = league.ppFgMissed
      fgMissedMax = league.fgMissedMax
      ppPatMissed = league.ppPatMissed
      ppDefTd = league.ppDefTd
      ppDefPtsAllowed0 = league.ppDefPtsAllowed0
      ppDefPtsAllowed1_6 = league.ppDefPtsAllowed1_6
      ppDefPtsAllowed7_13 = league.ppDefPtsAllowed7_13
      ppDefPtsAllowed14_20 = league.ppDefPtsAllowed14_20
      ppDefPtsAllowed21_27 = league.ppDefPtsAllowed21_27
      ppDefPtsAllowed28_34 = league.ppDefPtsAllowed28_34
      ppDefPtsAllowed35 = league.ppDefPtsAllowed35
      ppDef4thDownStop = league.ppDef4thDownStop
      ppDefSack = league.ppDefSack
      ppDefInterception = league.ppDefInterception
      ppDefFumbleRecovery = league.ppDefFumbleRecovery
      ppDefSafety = league. ppDefSafety
      ppDefForcedFumble = league.ppDefForcedFumble
      ppDefBlockedKick = league.ppDefBlockedKick
      ppSptTd = league.ppSptTd
      ppSptForcedFumble = league.ppSptForcedFumble
      ppSptFumbleRecovery = league.ppSptFumbleRecovery
      ppFumbleTd = league.ppFumbleTd
      ppFumbleLost = league.ppFumbleLost
      playoffWeek = league.playoffWeek
    }

  fun findById(id: Int): League? = League.findById(id)

  fun delete(id: Int): League? =
    League.findById(id)
      ?.apply{ delete() }
}

class League(id: EntityID<Int>): IntEntity(id) {
  companion object : IntEntityClass<League>(Leagues)
  var ownerId by Leagues.owner_id
  var name by Leagues.name
  var qbs by Leagues.qbs
  var rbs by Leagues.rbs
  var wrs by Leagues.wrs
  var tes by Leagues.tes
  var flex by Leagues.flex
  var kicker by Leagues.kicker
  var def by Leagues.def
  var ppPassYd by Leagues.pp_pass_yd
  var ppPassTd by Leagues.pp_pass_td
  var ppPass2pt by Leagues.pp_pass_2pt
  var ppPassInt by Leagues.pp_pass_int
  var ppPassPick6 by Leagues.pp_pass_pick6
  var ppRushYd by Leagues.pp_rush_yd
  var ppRushTd by Leagues.pp_rush_td
  var ppRush2pt by Leagues.pp_rush_2pt
  var ppRecRecep by Leagues.pp_rec_recep
  var ppRecYd by Leagues.pp_rec_yd
  var ppRecTd by Leagues.pp_rec_td
  var ppRec2pt by Leagues.pp_rec_2pt
  var ppFg0_19 by Leagues.pp_fg_0_19
  var ppFg20_29 by Leagues.pp_fg_20_29
  var ppFg30_39 by Leagues.pp_fg_30_39
  var ppFg40_49 by Leagues.pp_fg_40_49
  var ppFg_50 by Leagues.pp_fg_50
  var ppPat by Leagues.pp_pat
  var ppFgMissed by Leagues.pp_fg_missed
  var fgMissedMax by Leagues.fg_missed_max
  var ppPatMissed by Leagues.pp_pat_missed
  var ppDefTd by Leagues.pp_def_td
  var ppDefPtsAllowed0 by Leagues.pp_def_pts_allowed_0
  var ppDefPtsAllowed1_6 by Leagues.pp_def_pts_allowed_1_6
  var ppDefPtsAllowed7_13 by Leagues.pp_def_pts_allowed_7_13
  var ppDefPtsAllowed14_20 by Leagues.pp_def_pts_allowed_14_20
  var ppDefPtsAllowed21_27 by Leagues.pp_def_pts_allowed_21_27
  var ppDefPtsAllowed28_34 by Leagues.pp_def_pts_allowed_28_34
  var ppDefPtsAllowed35 by Leagues.pp_def_pts_allowed_35
  var ppDef4thDownStop by Leagues.pp_def_4th_down_stop
  var ppDefSack by Leagues.pp_def_sack
  var ppDefInterception by Leagues.pp_def_interception
  var ppDefFumbleRecovery by Leagues.pp_def_fumble_recovery
  var ppDefSafety by Leagues.pp_def_safety
  var ppDefForcedFumble by Leagues.pp_def_forced_fumble
  var ppDefBlockedKick by Leagues.pp_def_blocked_kick
  var ppSptTd by Leagues.pp_spt_td
  var ppSptForcedFumble by Leagues.pp_spt_forced_fumble
  var ppSptFumbleRecovery by Leagues.pp_spt_fumble_recovery
  var ppFumbleTd by Leagues.pp_fumble_td
  var ppFumbleLost by Leagues.pp_fumble_lost
  var playoffWeek by Leagues.playoff_week
}