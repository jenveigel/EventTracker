angular.module('appModule')
.component('activityList', {
	templateUrl : 'app/appModule/actvityList/activityList.component.html',
		controller : function(activityService) {
			var vm = this;
			
			vm.activities = [];
			
//			index/reload
//			addActivity
//			updateActivity
//			deleteActivity
			
		},
	controllerAs : 'vm'
});