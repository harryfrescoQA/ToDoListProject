// Get form element when button pressed
document
  .querySelector("form.viewRecord")
  .addEventListener("submit", function (stop) {
    stop.preventDefault();
    let formElements = document.querySelector("form.viewRecord").elements;
    console.log(formElements)

    let name=formElements["nameInput"].value;

    // JSON object for data
    let data = {

      "title":name

    }
    // Send to create function
    create(data)
    // Send user to start page
    window.location.replace("startPage.html");
  });

// Post data to url
function create(data){
    fetch("http://localhost:9092/list/create", {
        method: 'post',
        headers: {
          "Content-type": "application/json; charset=UTF-8"
        },
        body:JSON.stringify(data)
      })
      .then(function (data) {
        console.log('Success! Response: ', data);
      })
      .catch(function (error) {
        console.log('Failed! Response: ', error);
      });
}