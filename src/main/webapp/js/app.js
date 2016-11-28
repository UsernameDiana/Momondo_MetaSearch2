var app = angular.module('MomondoMetaApp', []);

app.config(function ($routeProvider) {
    $routeProvider
            .when("/home", {
                templateUrl: "views/index.html",
                controller: "SearchCtrl"
            })
            .when("/documentation", {
                templateUrl: "views/documentation.html",
                controller: "DocController"
            })
            .when("/about", {
                templateUrl: "views/about.html",
                controller: "AboutController"
            }) 
            .otherwise({
                redirectTo: "/home"
            })
});

app.controller('DocController', function ($scope) {
    $scope.documentation = "Documentation view";
})

app.controller('AboutController', function ($scope) {
    $scope.about = "About view";
})

app.controller('SearchCtrl', function ($scope, $http) {
    $scope.flight = {};

    $scope.search3Param = function ($scope) {

        $http.get('http://airline-plaul.rhcloud.com/api/flightinfo/', {
            params: {
                origin: $scope.flight.startPlace,
                destination: $scope.flight.endPlace,
                date: $scope.flight.startDate

            }
        }).then(function (response, $scope) {
            scope.flight = response;
        });
    };

    $scope.search2Param = function ($scope) {

        $http.get('http://airline-plaul.rhcloud.com/api/flightinfo/', {
            params: {
                origin: $scope.flight.startPlace,
                destination: $scope.flight.endPlace
            }
        }).then(function (response, $scope) {
            scope.flight = response;
        });
    };
});
