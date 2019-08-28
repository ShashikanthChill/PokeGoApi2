///* 
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//var row_id;
//$(function tables() {
//    $("#table tr #btn_del").click(function () {
//        row_id = this.closest('tr').rowIndex;
//        var id = getIdFromRow(row_id);
//        $.post("deleteraidbossinfo", {id: id}, function () {
//            location.reload(true);
//        });
//    });
//    $("#table tr #btn_edit").click(function () {
//        row_id = this.closest('tr').rowIndex;
//        var id = getIdFromRow(row_id);
//        console.log("edit btn pressed at row: " + row_id + " for Id: " + id);
//        fillUpdateForm(row_id);
//        $('#updateModal').modal('show');
//    });
//});
//function getIdFromRow(rowId)
//{
//    var table = document.getElementById("table");
//    var cells = table.rows[rowId].cells;
//    return cells[0].innerHTML;
//}
//
//function fillUpdateForm(rowId)
//{
//    var table = document.getElementById("table");
//    var cells = table.rows[rowId].cells;
//    document.getElementById('entry_id_u').value = parseInt(cells[0].innerHTML.trim());
//    document.getElementById('pokeDex_u').value = parseInt(cells[1].innerHTML.trim());
//    document.getElementById('raidBoss_u').value = cells[2].innerHTML.trim();
//    document.getElementById('type1_u').value = cells[3].innerHTML.trim();
//    document.getElementById('type2_u').value = cells[4].innerHTML.trim();
//    document.getElementById('tier_u').value = parseInt(cells[5].innerHTML.trim());
//    document.getElementById('gen_u').value = parseInt(cells[6].innerHTML.trim());
//    document.getElementById('raidBossCp_u').value = parseInt(cells[7].innerHTML.trim());
//    document.getElementById('minCpNonBoosted_u').value = parseInt(cells[8].innerHTML.trim());
//    document.getElementById('maxCpNonBoosted_u').value = parseInt(cells[9].innerHTML.trim());
//    document.getElementById('minCpBoosted_u').value = parseInt(cells[10].innerHTML.trim());
//    document.getElementById('maxCpBoosted_u').value = parseInt(cells[11].innerHTML.trim());
//    document.getElementById('groupSizeDifficulty_u').value = parseInt(cells[12].innerHTML.trim());
//    document.getElementById('catchRate_u').value = parseFloat(cells[13].innerHTML.trim());
//    document.getElementById('shinyavailable_u').checked = cells[14].innerHTML.trim() === "true";
//}
//
//function validateInsertForm() {
//
//    var x = document.getElementById('tier').value;
//    if (isNaN(parseInt(x))) {
//        alert("Tier is not selected.");
//        return false;
//    }
//
//    x = document.getElementById('pokeDex').value;
//    if (isNaN(parseInt(x)) || parseInt(x) <= 0) {
//        alert("Pokedex should not be empty or <=0.");
//        return false;
//    }
//
//    x = document.getElementById('gen').value;
//    if (isNaN(parseInt(x)) || parseInt(x) <= 0) {
//        alert("Gen should not be empty or <=0.");
//        return false;
//    }
//
//    var x = document.getElementById('raidBoss').value;
//    if (x === "") {
//        alert("Raid Boss name should not be empty.");
//        return false;
//    }
//
//    x = document.getElementById('raidBossCp').value;
//    if (isNaN(parseInt(x)) || parseInt(x) <= 0) {
//        alert("Raid Boss CP should not be empty or <=0.");
//        return false;
//    }
//
//    var x = document.getElementById('type1').value;
//    if (x === "Pick a type") {
//        alert("Pokemon Type 1 is not selected.");
//        return false;
//    }
//
//    x = document.getElementById('minCpNonBoosted').value;
//    if (isNaN(parseInt(x)) || parseInt(x) <= 0 || parseInt(x) >= parseInt(document.getElementById('raidBossCp').value)) {
//        alert("Min CP(non-boosted) should not be empty or <= 0 or >= Raid Boss CP.");
//        return false;
//    }
//
//    x = document.getElementById('maxCpNonBoosted').value;
//    if (isNaN(parseInt(x)) || parseInt(x) <= parseInt(document.getElementById('minCpNonBoosted').value) || parseInt(x) >= parseInt(document.getElementById('raidBossCp').value)) {
//        alert("Max CP(non-boosted) should not be empty or <= Min CP(non-boosted) or >= Raid Boss CP.");
//        return false;
//    }
//
//    x = document.getElementById('minCpBoosted').value;
//    if (isNaN(parseInt(x)) || parseInt(x) <= 0 || parseInt(x) <= parseInt(document.getElementById('maxCpNonBoosted').value) || parseInt(x) >= parseInt(document.getElementById('raidBossCp').value)) {
//        alert("Min CP(boosted) should not be empty or <= Max CP(non-boosted) or >= Raid Boss CP.");
//        return false;
//    }
//
//    x = document.getElementById('maxCpBoosted').value;
//    if (isNaN(parseInt(x)) || parseInt(x) <= parseInt(document.getElementById('minCpBoosted').value) || parseInt(x) >= parseInt(document.getElementById('raidBossCp').value)) {
//        alert("Max CP(boosted) should not be empty or <= Min CP(boosted) or >= Raid Boss CP.");
//        return false;
//    }
//
//    x = document.getElementById('groupSizeDifficulty').value;
//    if (isNaN(parseInt(x)) || parseInt(x) <= 0) {
//        alert("Recommended Group Size should not be empty or <=0.");
//        return false;
//    }
//
//    x = document.getElementById('catchRate').value;
//    if (isNaN(parseInt(x)) || parseInt(x) <= 0) {
//        alert("Catch Rate should not be empty or <=0.");
//        return false;
//    }
//
//    return true;
//}
//
//function validateUpdateForm() {
//    var x = document.getElementById('tier_u').value;
//    if (isNaN(parseInt(x))) {
//        alert("Tier is not selected.");
//        return false;
//    }
//
//    x = document.getElementById('pokeDex_u').value;
//    if (isNaN(parseInt(x)) || parseInt(x) <= 0) {
//        alert("Pokedex should not be empty or <=0.");
//        return false;
//    }
//
//    x = document.getElementById('gen_u').value;
//    if (isNaN(parseInt(x)) || parseInt(x) <= 0) {
//        alert("Gen should not be empty or <=0.");
//        return false;
//    }
//
//    var x = document.getElementById('raidBoss_u').value;
//    if (x === "") {
//        alert("Raid Boss name should not be empty.");
//        return false;
//    }
//
//    x = document.getElementById('raidBossCp_u').value;
//    if (isNaN(parseInt(x)) || parseInt(x) <= 0) {
//        alert("Raid Boss CP should not be empty or <=0.");
//        return false;
//    }
//
//    var x = document.getElementById('type1_u').value;
//    if (x === "Pick a type") {
//        alert("Pokemon Type 1 is not selected.");
//        return false;
//    }
//
//    x = document.getElementById('minCpNonBoosted_u').value;
//    if (isNaN(parseInt(x)) || parseInt(x) <= 0 || parseInt(x) >= parseInt(document.getElementById('raidBossCp').value)) {
//        alert("Min CP(non-boosted) should not be empty or <= 0 or >= Raid Boss CP.");
//        return false;
//    }
//
//    x = document.getElementById('maxCpNonBoosted_u').value;
//    if (isNaN(parseInt(x)) || parseInt(x) <= parseInt(document.getElementById('minCpNonBoosted').value) || parseInt(x) >= parseInt(document.getElementById('raidBossCp').value)) {
//        alert("Max CP(non-boosted) should not be empty or <= Min CP(non-boosted) or >= Raid Boss CP.");
//        return false;
//    }
//
//    x = document.getElementById('minCpBoosted_u').value;
//    if (isNaN(parseInt(x)) || parseInt(x) <= 0 || parseInt(x) <= parseInt(document.getElementById('maxCpNonBoosted').value) || parseInt(x) >= parseInt(document.getElementById('raidBossCp').value)) {
//        alert("Min CP(boosted) should not be empty or <= Max CP(non-boosted) or >= Raid Boss CP.");
//        return false;
//    }
//
//    x = document.getElementById('maxCpBoosted_u').value;
//    if (isNaN(parseInt(x)) || parseInt(x) <= parseInt(document.getElementById('minCpBoosted').value) || parseInt(x) >= parseInt(document.getElementById('raidBossCp').value)) {
//        alert("Max CP(boosted) should not be empty or <= Min CP(boosted) or >= Raid Boss CP.");
//        return false;
//    }
//
//    x = document.getElementById('groupSizeDifficulty_u').value;
//    if (isNaN(parseInt(x)) || parseInt(x) <= 0) {
//        alert("Recommended Group Size should not be empty or <=0.");
//        return false;
//    }
//
//    x = document.getElementById('catchRate_u').value;
//    if (isNaN(parseInt(x)) || parseInt(x) <= 0) {
//        alert("Recommended Group Size should not be empty or <=0.");
//        return false;
//    }
//
//    return true;
//}
//
