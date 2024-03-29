-- noinspection SqlNoDataSourceInspectionForFile

CREATE DATABASE demco_ff;

\c demco_ff;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id            SERIAL PRIMARY KEY,
    first_name    VARCHAR(50) NOT NULL,
    last_name     VARCHAR(50) NOT NULL,
    username      VARCHAR(50) NOT NULL,
    email         VARCHAR(250) UNIQUE NOT NULL,
    password      VARCHAR(250) NOT NULL
);

CREATE TABLE leagues (
    id                          SERIAL PRIMARY KEY,
    owner_id                    INTEGER UNIQUE NOT NULL,
    "name"                      VARCHAR(50) NOT NULL,
    qbs                         SMALLINT NOT NULL,
    rbs                         SMALLINT NOT NULL,
    wrs                         SMALLINT NOT NULL,
    tes                         SMALLINT NOT NULL,
    flex                        SMALLINT NOT NULL,
    kicker                      SMALLINT NOT NULL,
    def                         SMALLINT NOT NULL,
    pp_pass_yd                  DECIMAL(2) NOT NULL,
    pp_pass_td                  SMALLINT NOT NULL,
    pp_pass_2pt                 SMALLINT NOT NULL,
    pp_pass_int                 SMALLINT NOT NULL,
    pp_pass_pick6               SMALLINT NOT NULL,
    pp_rush_yd                  DECIMAL(2) NOT NULL,
    pp_rush_td                  SMALLINT NOT NULL,
    pp_rush_2pt                 SMALLINT NOT NULL,
    pp_rec_recep                DECIMAL(2) NOT NULL,
    pp_rec_yd                   DECIMAL(2) NOT NULL,
    pp_rec_td                   SMALLINT NOT NULL,
    pp_rec_2pt                  SMALLINT NOT NULL,
    pp_fg_0_19                  SMALLINT NOT NULL,
    pp_fg_20_29                 SMALLINT NOT NULL,
    pp_fg_30_39                 SMALLINT NOT NULL,
    pp_fg_40_49                 SMALLINT NOT NULL,
    pp_fg_50                    SMALLINT NOT NULL,
    pp_pat                      SMALLINT NOT NULL,
    pp_fg_missed                SMALLINT NOT NULL,
    fg_missed_max               SMALLINT NOT NULL,
    pp_pat_missed               SMALLINT NOT NULL,
    pp_def_td                   SMALLINT NOT NULL,
    pp_def_pts_allowed_0        SMALLINT NOT NULL,
    pp_def_pts_allowed_1_6      SMALLINT NOT NULL,
    pp_def_pts_allowed_7_13     SMALLINT NOT NULL,
    pp_def_pts_allowed_14_20    SMALLINT NOT NULL,
    pp_def_pts_allowed_21_27    SMALLINT NOT NULL,
    pp_def_pts_allowed_28_34    SMALLINT NOT NULL,
    pp_def_pts_allowed_35       SMALLINT NOT NULL,
    pp_def_4th_down_stop        SMALLINT NOT NULL,
    pp_def_sack                 SMALLINT NOT NULL,
    pp_def_interception         SMALLINT NOT NULL,
    pp_def_fumble_recovery      SMALLINT NOT NULL,
    pp_def_safety               SMALLINT NOT NULL,
    pp_def_forced_fumble        SMALLINT NOT NULL,
    pp_def_blocked_kick         SMALLINT NOT NULL,
    pp_spt_td                   SMALLINT NOT NULL,
    pp_spt_forced_fumble        SMALLINT NOT NULL,
    pp_spt_fumble_recovery      SMALLINT NOT NULL,
    pp_fumble_td                SMALLINT NOT NULL,
    pp_fumble_lost              SMALLINT NOT NULL,
    playoff_week                SMALLINT NOT NULL
);