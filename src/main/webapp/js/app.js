var app = angular.module('MomondoMetaApp', ['ngRoute']);

app.config(function ($routeProvider) {
    $routeProvider
            .when("/home", {
                templateUrl: "views/home.html",
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
            .when("/info/:index", {
                templateUrl: "views/bookdetail.html",
                controller: "ProductController"
            })
            .otherwise({
                redirectTo: "/index"
            });
});

app.controller('DocController', function ($scope) {
    $scope.documentation = "Documentation view";
});

app.controller('AboutController', function ($scope) {
    $scope.about = "About view";
});

app.controller('SearchCtrl', function ($scope, $http) {
    
    $scope.search3Param = function () {
        
        var date;        
        date = new Date($scope.myDate);
        var dateTemp = date.getTime() - (date.getTimezoneOffset() * 60000);
        var adjustedDate = new Date(dateTemp).toISOString();
        
        JSON.stringify($scope.date);
        
        $http({
            method: 'GET',
            url: 'api/search/' + $scope.flight.startPlace
                    + "/" + adjustedDate + "/" + $scope.flight.passangers            
        }).then(function (response) {  
            
            $scope.result = JSON.stringify(response.data);            
            
            console.log($scope.result);
        });
    };
});
