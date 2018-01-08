angular.module('appModule')
.component('activityList', {
	templateUrl : "app/appModule/activityList/activityList.component.html",
		controller : function(activityService) {
			var vm = this;
						
			vm.selected = null;
			
			vm.editActivity = null;
			
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
				copy.level = '';
				copy.duration = 0;
				copy.day = '';
				activityService.create(copy)
				.then(function(response) {
					reload();
				});
			}
 
			vm.updateActivity = function(activity) {
				activityService.update(activity)
				.then(function(response){
					vm.activities = response.data;
					reload();
				});
				vm.selected = activity;
				vm.editActivity = null;
			}
			
			vm.deleteActivity = function(id) {
				activityService.destroy(id)
				.then(function(response) {
					reload();
				});
			}
			
			vm.displayActivity = function(activity) {
				vm.selected = angular.copy(activity);
			}
			
			vm.displayActivities = function() {
				vm.selected = null;
			}
			
			vm.setEditActivity = function(activity) {
				vm.editActivity = angular.copy(vm.selected);
			}
			
			vm.countActivities = function() {
				return vm.activities.length;
			}
			
			vm.totalHours = function(activity) {
				var total = 0;
				for (var i = 0; i < vm.activities.length; i++) {
					total += vm.activities[i].duration; 
				}
				return total;
			}
			
			
		},
	controllerAs : 'vm'
});