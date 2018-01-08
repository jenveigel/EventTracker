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
			

//			addActivity
//			updateActivity
//			deleteActivity
			
		},
	controllerAs : 'vm'
});