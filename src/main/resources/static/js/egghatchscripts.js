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
//        console.log(row_id + " " + id);
//        $.post("deleteegginfo", {id: id}, function () {
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
//    document.getElementById('pokemon_u').value = cells[1].innerHTML.trim();
//    document.getElementById('eggdistance_u').value = parseInt(cells[2].innerHTML.trim());
//    document.getElementById('mincp_u').value = parseInt(cells[3].innerHTML.trim());
//    document.getElementById('maxcp_u').value = parseInt(cells[4].innerHTML.trim());
//    document.getElementById('shinyavailable_u').checked = cells[5].innerHTML.trim() === "true";
//}
//
//function validateInsertForm() {
//
//    var x = document.getElementById('pokemon').value;
//    if (x === "") {
//        alert("Pokemon name should not be empty.");
//        return false;
//    }
//
//    x = document.getElementById('eggdistance').value;
//    if (isNaN(parseInt(x))) {
//        alert("Egg distance is not selected");
//        return false;
//    } else {
//        switch (parseInt(x)) {
//            case 2:
//                break;
//            case 5:
//                break;
//            case 7:
//                break;
//            case 10:
//                break;
//
//            default:
//            {
//                alert("Egg distance is not valid.");
//                return false;
//            }
//        }
//    }
//
//    x = document.getElementById('mincp').value;
//    if (isNaN(parseInt(x)) || parseInt(x) <= 0) {
//        alert("Min CP should not be empty or <= 0.");
//        return false;
//    }
//
//    x = document.getElementById('maxcp').value;
//    if (isNaN(parseInt(x)) || parseInt(x) <= parseInt(document.getElementById('mincp').value)) {
//        alert("Max CP should not be empty or <= Min CP.");
//        return false;
//    }
//
//    return true;
//}
//
//function validateUpdateForm() {
//
//    var x = document.getElementById('pokemon_u').value;
//    if (x === "") {
//        alert("Pokemon name should not be empty.");
//        return false;
//    }
//
//    x = document.getElementById('eggdistance_u').value;
//    if (isNaN(parseInt(x))) {
//        alert("Egg distance is not selected");
//        return false;
//    } else {
//        switch (parseInt(x)) {
//            case 2:
//                break;
//            case 5:
//                break;
//            case 7:
//                break;
//            case 10:
//                break;
//
//            default:
//            {
//                alert("Egg distance is not valid.");
//                return false;
//            }
//        }
//    }
//
//    x = document.getElementById('mincp_u').value;
//    if (isNaN(parseInt(x)) || parseInt(x) <= 0) {
//        alert("Min CP should not be empty or <= 0.");
//        return false;
//    }
//
//    x = document.getElementById('maxcp_u').value;
//    if (isNaN(parseInt(x)) || parseInt(x) <= parseInt(document.getElementById('mincp_u').value)) {
//        alert("Max CP should not be empty <= Min CP.");
//        return false;
//    }
//
//    return true;
//}
