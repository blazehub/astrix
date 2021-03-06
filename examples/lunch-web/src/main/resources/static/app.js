'use strict'; // Strict javascript validation

angular.isUndefinedOrNull = function(value) {
	return angular.isUndefined(value) || value === null || value.length === 0;
};

var lunchApp = angular.module("lunchApp", []);

lunchApp.factory("LunchService", function($http) {
	var service = {};
	service.list = function() {
		return $http.get("/lunchrestaurants/");
	}
	service.add = function(restaurant, onSuccess) {
		$http.post("/lunchrestaurants/", restaurant).
			success(function(data, status, headers, config) {
				onSuccess(data);
			});
	}
	service.random = function(restaurant) {
		return $http.get("/randomrestaurant/");
	}
	service.grade = function(restaurant, onSuccess) {
		$http.post("/grade/" + restaurant.name, restaurant.grade).
			success(function(data, status, headers, config) {
				onSuccess(data);
			});
	}
	return service;
});


lunchApp.controller("LunchAppController", function ($scope, LunchService) {
	$scope.restaurants = [];
	$scope.add = function (restaurant) {
		newRestaurant = LunchService.add(restaurant, function(newRestaurant) {
			$scope.restaurants.push(newRestaurant);
		});
	}
	$scope.grade = function (restaurant) {
		LunchService.grade(restaurant, function(restaurant) {
			for (var i = 0; i < $scope.restaurants.length; i++) {
				if ($scope.restaurants[i].name == restaurant.name) {
					$scope.restaurants[i] = restaurant;
				}
			}
		});
	}
	var getRestaurants = function () {
		var restaurantPromise = LunchService.list();
		restaurantPromise.success(function (data, status) {
			$scope.restaurants = data;
		})
	}
	getRestaurants();
});

lunchApp.controller("LunchSuggestionController", function ($scope, LunchService) {
	var randomRestaurant = function () {
		var restaurantPromise = LunchService.random();
		restaurantPromise.success(function (data, status) {
			$scope.restaurant = data;
		})
	}
	randomRestaurant();
});

lunchApp.filter("StringReplace", function () {
	return function (input, what, whith) {
		return input.replace(what, whith);
	};
})