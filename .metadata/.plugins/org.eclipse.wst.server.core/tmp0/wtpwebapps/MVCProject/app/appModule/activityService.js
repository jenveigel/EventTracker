angular.module('appModule')
.factory('activityService', function($http){
	
	var service = {};
	
	var activities = [];
	
	service.index = function(){
		return $http({
			method : 'GET',
			url : 'rest/activity'
		})
	}
	
//	index
//	create
//	update
//	destroy
	
	
	return service;
});