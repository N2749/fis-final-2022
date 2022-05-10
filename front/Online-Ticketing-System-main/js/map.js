
function initMap() {
  const markerArray = [];
  const directionsService = new google.maps.DirectionsService();

  const map = new google.maps.Map(document.getElementById("map"), {
    zoom: 7,
    center: { lat: 43.239863, lng: 76.886160 },
  });
  const directionsRenderer = new google.maps.DirectionsRenderer({ map: map });
  var stepDisplay;
  var activeInfo;

 onChangeHandler = function () {
    calculateAndDisplayRoute(
      directionsRenderer,
      directionsService,
      markerArray,
      stepDisplay,
      map
    );
  };

}

function calculateAndDisplayRoute(
  directionsRenderer,
  directionsService,
  markerArray,
  stepDisplay,
  map
) {
  for (let i = 0; i < markerArray.length; i++) {
    markerArray[i].setMap(null);
  }

  directionsService
    .route({
      origin: document.getElementById("start").value,
      destination: document.getElementById("end").value,
      travelMode: google.maps.TravelMode.WALKING,
    })
    .then((result) => {
      directionsRenderer.setDirections(result);
      showSteps(result, markerArray, stepDisplay, map);
    })
    .catch((e) => {
      
    });
}

function showSteps(directionResult, markerArray, stepDisplay, map) {
  const myRoute = directionResult.routes[0].legs[0];

  for (let i = 0; i < 3; i++) {
    const marker = (markerArray[i] =
      markerArray[i] || new google.maps.Marker());
    
    marker.setMap(map);
    var typeArray=["Coach","Coach with beds", "Shuttle", "Minibus"];
  var contentdata="<strong>Tracking</strong><p>Type of Bus: "+typeArray[Math.floor(Math.random() * 3)+0]+"</p><p>Bus number: "+(Math.floor(Math.random() * 999999)+100000)+"</p>";
  stepDisplay = new google.maps.InfoWindow({
  content: contentdata,
  });
    marker.setPosition(myRoute.steps[Math.floor(Math.random() * 60)+20].start_location);
    attachInstructionText(
      stepDisplay,
      marker,
      map
    );
  }
}

function attachInstructionText(stepDisplay, marker, text, map) {
  google.maps.event.addListener(marker, "click", () => {
    stepDisplay.setContent(text);
    stepDisplay.open(map, marker);
  });
}

window.initMap = initMap;
