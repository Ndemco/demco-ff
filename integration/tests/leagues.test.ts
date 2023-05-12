import {expect, test} from "@playwright/test";
import sql from '../db/sql'

test.describe('/leagues', function(){
  test('should create a league', async ({ request }) => {
    const response = await request.post('/leagues', {
      data: {
        "ownerId": 1,
        "name": "The Boys",
        "qbs": 1,
        "rbs": 2,
        "wrs": 3,
        "tes": 1,
        "flex": 1,
        "kicker": 1,
        "def": 1,
        "ppPassYd": 0.1,
        "ppPassTd": 6,
        "ppPass2pt": 2,
        "ppPassInt": -2,
        "ppPassPick6": -2,
        "ppRushYd": .1,
        "ppRushTd": 6,
        "ppRush2pt": 2,
        "ppRecRecep": 1.0,
        "ppRecYd": .1,
        "ppRecTd": 6,
        "ppRec2pt": 2,
        "ppFg0_19": 1,
        "ppFg20_29": 2,
        "ppFg30_39": 3,
        "ppFg40_49": 4,
        "ppFg_50": 5,
        "ppPat": 1,
        "ppFgMissed": -1,
        "fgMissedMax": 70,
        "ppPatMissed": -1,
        "ppDefTd": 6,
        "ppDefPtsAllowed0": 10,
        "ppDefPtsAllowed1_6": 7,
        "ppDefPtsAllowed7_13": 6,
        "ppDefPtsAllowed14_20": 5,
        "ppDefPtsAllowed21_27": 2,
        "ppDefPtsAllowed28_34": 1,
        "ppDefPtsAllowed35": 0,
        "ppDef4thDownStop": 1,
        "ppDefSack": 1,
        "ppDefInterception": 2,
        "ppDefFumbleRecovery": 2,
        "ppDefSafety": 2,
        "ppDefForcedFumble": 0,
        "ppDefBlockedKick": 1,
        "ppSptTd": 6,
        "ppSptForcedFumble": 0,
        "ppSptFumbleRecovery": 2,
        "ppFumbleTd": 6,
        "ppFumbleLost": -1,
        "playoffWeek": 13
      }
    });

    expect(response.status()).toEqual(201);
    expect(await response.json()).toEqual({
      "id": 1,
      "ownerId": 1,
      "name": "The Boys",
      "qbs": 1,
      "rbs": 2,
      "wrs": 3,
      "tes": 1,
      "flex": 1,
      "kicker": 1,
      "def": 1,
      "ppPassYd": 0.1,
      "ppPassTd": 6,
      "ppPass2pt": 2,
      "ppPassInt": -2,
      "ppPassPick6": -2,
      "ppRushYd": 0.1,
      "ppRushTd": 6,
      "ppRush2pt": 2,
      "ppRecRecep": 1,
      "ppRecYd": 0.1,
      "ppRecTd": 6,
      "ppRec2pt": 2,
      "ppFg0_19": 1,
      "ppFg20_29": 2,
      "ppFg30_39": 3,
      "ppFg40_49": 4,
      "ppFg_50": 5,
      "ppPat": 1,
      "ppFgMissed": -1,
      "fgMissedMax": 70,
      "ppPatMissed": -1,
      "ppDefTd": 6,
      "ppDefPtsAllowed0": 10,
      "ppDefPtsAllowed1_6": 7,
      "ppDefPtsAllowed7_13": 6,
      "ppDefPtsAllowed14_20": 5,
      "ppDefPtsAllowed21_27": 2,
      "ppDefPtsAllowed28_34": 1,
      "ppDefPtsAllowed35": 0,
      "ppDef4thDownStop": 1,
      "ppDefSack": 1,
      "ppDefInterception": 2,
      "ppDefFumbleRecovery": 2,
      "ppDefSafety": 2,
      "ppDefForcedFumble": 0,
      "ppDefBlockedKick": 1,
      "ppSptTd": 6,
      "ppSptForcedFumble": 0,
      "ppSptFumbleRecovery": 2,
      "ppFumbleTd": 6,
      "ppFumbleLost": -1,
      "playoffWeek": 13
    });
  });

  test('should delete a league', async ({ request }) => {
    let results = await sql`
        select id from leagues where id = 1
    `;
    expect(results).toEqual([{ id: 1 }])

    const response = await request.delete('/leagues/1');
    expect(response.status()).toEqual(200);

    results = await sql`
        select id from leagues where id = 1
    `;
    expect(results).toEqual([]);
  });
});