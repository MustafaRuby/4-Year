ready_list = ["noodles", "bamboo", "soia Sauce", "green onions", "chicken powder"];
let list = document.getElementById("ready-list");
let create_list = document.getElementById("list");


document.getElementById("ready-list-create").onclick = function(){
    let list_element;
    
    for (let i = 0; i < ready_list.length; i++) {
        list_element = document.createElement("li");
        list_element.textContent = ready_list[i];
        list.appendChild(list_element);
    }
}

document.getElementById("eliminate-list-create").onclick = function(){
    list.innerHTML = "";
}

document.getElementById("list-create").onclick = function() {
    let list_element = document.createElement("li");
    let input = document.getElementById("input-box").value;

    if(input != ""){
        list_element.textContent = input;
        create_list.appendChild(list_element);
    }
    
}

document.getElementById("eliminate-list").onclick = function(){
    create_list.innerHTML = "";
}


