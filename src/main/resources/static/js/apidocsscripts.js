/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var raidboss_data_sample = [{
        "Poké Index": 386,
        "Pokémon": "Deoxys (Defense Forme)",
        "Type(s)": [
            "Psychic"
        ],
        "Boosted Weather": [
            "Windy"
        ],
        "Generation": 3,
        "Tier": "EX",
        "Boss Cp": 33018,
        "Min Cp(Non-Boosted)": 1228,
        "Max Cp(Non-Boosted)": 1299,
        "Min Cp(Boosted)": 1535,
        "Max Cp(Boosted)": 1624,
        "Recommended Group Size": 6,
        "Shiny Availability": false
    }];

var raidboss_metadata_sample = {
    "Total Raid Bosses": 23,
    "Raid Boss Levels": 6,
    "Raid Bosses Per Level": {
        "1": 4,
        "2": 5,
        "3": 6,
        "4": 5,
        "5": 2,
        "EX": 1
    },
    "Shiny Raid Bosses": 12,
    "Non-Shiny Raid Bosses": 11
};

var eggpool_data_sample = [{
        "Egg Distance": 2,
        "Poke Index": 172,
        "Pokémon": "Pichu",
        "Type(s)": [
            "Electric"
        ],
        "Min Cp": 240,
        "Max Cp": 270,
        "Shiny Availability": true
    }];

var eggpool_metadata_sample = {
    "Total Hatches": 117,
    "Hatch Distance Pools": 4,
    "Hatches Per Pool": {
        "10": 14,
        "2": 43,
        "5": 37,
        "7": 23
    },
    "Shiny Hatches": 62,
    "Non-Shiny Hatches": 55
};

var breakthrough_data_sample = [{
        "Poké Index": 249,
        "Pokémon": "Lugia",
        "Type(s)": [
            "Psychic",
            "Flying"
        ],
        "Min Cp": 1521,
        "Max Cp": 1587,
        "Shiny Availability": true
    }];

var breakthrough_metadata_sample = {
    "Total Encounters": 4,
    "Shiny Encounters": 4,
    "Non-Shiny Encounters": 0
};

var typeweather_data_sample = [{
        "Pokémon Type": "Water",
        "Boosted Weather": "Rain"
    }];

var typeweather_sorted_data_sample = [{
        "Weather": "Windy",
        "Boosted Types": [
            "Flying",
            "Psychic",
            "Dragon"
        ]
    }
];

var typeweather_metadata_sample = {
    "Total Pokémon Types": 18,
    "Total Weather Types": 7,
    "Weather Types": [
        "Partly Cloudy",
        "Clear/Sunny",
        "Rain",
        "Snow",
        "Cloudy",
        "Windy",
        "Fog"
    ]
};

var typeeffectiveness_data_sample = [{
        "Type": "Electric",
        "Super Effective": [
            "Water",
            "Flying"
        ],
        "Nomal Effective": [
            "Normal",
            "Fire",
            "Ice",
            "Fighting",
            "Poison",
            "Psychic",
            "Bug",
            "Rock",
            "Ghost",
            "Dark",
            "Steel"
        ],
        "Not Very Effective": [
            "Electric",
            "Grass",
            "Dragon"
        ],
        "Zero Effective": [
            "Ground"
        ]
    }];

var typeeffectiveness_metadata_sample = {
    "Total Types": 18,
    "Effectiveness Levels": [
        "Zero Effective",
        "Not Very Effective",
        "Normal Effective",
        "Super Effective"
    ]
};

var textedRaidbossJson = JSON.stringify(raidboss_data_sample, undefined, 4);
var textedRaidbossMetaJson = JSON.stringify(raidboss_metadata_sample, undefined, 4);
var textedEggpoolJson = JSON.stringify(eggpool_data_sample, undefined, 4);
var textedEggpoolMetaJson = JSON.stringify(eggpool_metadata_sample, undefined, 4);
var textedBreakthroughJson = JSON.stringify(breakthrough_data_sample, undefined, 4);
var textedBreakthroughMetaJson = JSON.stringify(breakthrough_metadata_sample, undefined, 4);
var textedTypeweatherJson = JSON.stringify(typeweather_data_sample, undefined, 4);
var textedTypeweatherSortedJson = JSON.stringify(typeweather_sorted_data_sample, undefined, 4);
var textedTypeweatherMetaJson = JSON.stringify(typeweather_metadata_sample, undefined, 4);
var textedTypeeffectivenessJson = JSON.stringify(typeeffectiveness_data_sample, undefined, 4);
var textedTypeeffectivenessMetaJson = JSON.stringify(typeeffectiveness_metadata_sample, undefined, 4);

console.log("setting text");
$('#raidbossTextarea').text(textedRaidbossJson);
$('#raidbossMetaTextarea').text(textedRaidbossMetaJson);
$('#eggpoolTextarea').text(textedEggpoolJson);
$('#eggpoolMetaTextarea').text(textedEggpoolMetaJson);
$('#breakthroughTextarea').text(textedBreakthroughJson);
$('#breakthroughMetaTextarea').text(textedBreakthroughMetaJson);
$('#typeweatherTextarea').text(textedTypeweatherJson);
$('#typeweatherSortedTextarea').text(textedTypeweatherSortedJson);
$('#typeweatherMetaTextarea').text(textedTypeweatherMetaJson);
$('#typeeffectivenessTextarea').text(textedTypeeffectivenessJson);
$('#typeeffectivenessMetaTextarea').text(textedTypeeffectivenessMetaJson);