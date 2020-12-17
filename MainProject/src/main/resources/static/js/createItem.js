//Get search params from URL
const params = new URLSearchParams(window.location.search);
 
for(let param of params ){
    let id = param[1];
    getData(id)
}

//Get data from form
function getData(id){
        // Put id in form 
        document.querySelector("input#idInput").value = id;

        document
        .querySelector("form.viewRecord")
        .addEventListener("submit", function (stop) {
          stop.preventDefault();
          let formElements = document.querySelector("form.viewRecord").elements;

          let name=formElements["nameInput"].value;
          let message=formElements["messageInput"].value;

          //JSON to hold data
          let data = {
            "done": false,
            "fullList": {
              "id": id
            },
            "title":name,
            "message":message
          }
          // Send to create function
          create(data)
          //Send user to read list window
          window.location.replace("readList.html?id="+ id);
        });
}

function create(data){
  // Post to url
    fetch("http://localhost:9092/item/create", {
        method: 'post',
        headers: {
          "Content-type": "application/json; charset=UTF-8"
        },
        body:JSON.stringify(data)
      })
      .then(function (data) {
        console.log('Correct! Response: ', data);
      })
      .catch(function (error) {
        console.log('Failed! Error: ', error);
      });
}