// function getData(uId) {
//     return new Promise((resolve) => {
//       setTimeout(() => {
//         console.log("Fetched the data!");
//         resolve("skc@gmail.com");
//       }, 4000);
//     });
//   }
  
//   console.log("start");
//   getData("skc").then(email => {
//     console.log("Email id of the user id is: " + email);
//   });
//   console.log("end");

function getData(uId) {
  return new Promise((resolve) => {
    setTimeout(() => {
      console.log("Fetched the data!");
      resolve("skc@gmail.com");
    }, 4000);
  });
}

async function displayEmail() {
  console.log("start");
  let email = await getData("skc");
  console.log("Email id of the user id is: " + email);
  console.log("end");
}

displayEmail();