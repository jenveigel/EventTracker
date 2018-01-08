angular.module('appModule')
.component('activityList', {
	templateUrl : "app/appModule/activityList/activityList.component.html",
		controller : function(activityService) {
			var vm = this;
			
			vm.activities = [];
			
			var reload = function() {
				activityService.index()
				.then(function(response){
					console.log(response);
					vm.activities = response.data;
				});
			}
			
			reload();
			
			 
			vm.addActivity = function(activity) {
				var copy = angular.copy(activity);
				activityService.create(copy)
				.then(function(response) {
					reload();
				});
			}
 
//			updateActivity
//			deleteActivity
			
		},
	controllerAs : 'vm'
});