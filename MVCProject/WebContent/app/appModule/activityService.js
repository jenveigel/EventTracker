angular.module('appModule')
.factory('activityService', function($http){
	
	var service = {};
	
	var activities = [];
	
	service.index = function(){
		return $http({
			method : 'GET',
			url : 'rest/activity'
		});
	}
	
	service.create = function(activity) {
		return $http({
			method : 'POST',
			url : 'rest/activity',
			headers : {
				'Content-Type' : 'application/json'
			},
			data : activity
		});
	}
	
	
	service.update = function(activity) {
		return $http({
			method : 'PUT',
			url : 'rest/activity/' + activity.id,
			headers : {
				'Content-Type' : 'application/json'
			},
			data : activity
		});
	}

	service.destroy = function(id) {
		return $http({
			method : 'DELETE',
			url : 'rest/activity/' + id
		});
	}
	
	
	return service;
});