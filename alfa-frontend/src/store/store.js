import Vue from "vue";
import Vuex from 'vuex';
import axios from "axios"

axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';

Vue.use(Vuex);

const GET_STATES_URL = "https://servicodados.ibge.gov.br/api/v1/localidades/estados";
const GET_CITIES_URL = (UF) => { return `https://servicodados.ibge.gov.br/api/v1/localidades/estados/${UF}/distritos`}
export default new Vuex.Store({
	state: {
		pageName: '',
		backUrl: '',
		states: [],
		cities: [],
		actualUser: {},
		modules: [],
		actualModule: {}
	},
	mutations: {
		setPageName(state, pageName) {
			state.pageName = pageName;
		},
		setBackUrl(state, backUrl) {
			state.backUrl = backUrl;
		},
		setStatesOnState(state, states){
			state.states = states;
		},
		setCitiesOnState(state, cities){
			state.cities = cities;
		},
		setActualUserOnState(state, actualUser){
			state.actualUser = actualUser;
		},
		setActualModuleOnState(state, actualModule){
			actualModule.lessons = actualModule.lessons.map(lesson => {return {title: lesson.title, description: lesson.contentText}});
			state.actualModule = actualModule;
		},
		setModulesOnState(state, modules){
			state.modules = modules;
		}
	},
	actions: {
		getStoryModules({commit}, idStory){
			idStory = 1;
			axios.get(`http://localhost:8085/api/story/${idStory}`).then((modules)=> {
				commit("setModulesOnState", modules.data);
			}).catch((error)=> {
				console.error(error);
			})
		},
		getModuleById({commit}, id){
			axios.get(`http://localhost:8085/api/story/modules/${id}`).then((module)=> {
				commit("setActualModuleOnState", module.data);
			}).catch((error)=> {
				console.error(error);
			})
		},
		getStates({commit}){
			axios.get(GET_STATES_URL).then((states)=> {
				commit("setStatesOnState", states.data);
			}).catch((error)=> {
				console.error(error);
			})
		},
		getCities({commit}, UF){
			axios.get(GET_CITIES_URL(UF)).then((cities)=> {
				commit("setCitiesOnState", cities.data);
			}).catch((error)=> {
				console.error(error);
			})
		},
		getUserByEmail({commit}, email){
			return new Promise((resolve, reject) => {
				axios.get("http://localhost:8085/api/auth", {params: {email: email}}).then(response => {
					commit("setActualUserOnState", response.data)
					sessionStorage.setItem("actualUser", JSON.stringify(response.data));
					resolve(response.data)
				})	
				.catch(error => {
					reject(error);
				})
			});
			
		},

		createStudentAction(_, student){
			student.pass = null;
			return new Promise((resolve,reject) => {
				axios.post("http://localhost:8085/api/student", student)
				.then(response => {
					resolve(response);
				})
				.catch(error => {
					reject(error);
				})

			});
		},
		createTeacherAction(_, teacher){
			teacher.pass = null;
			return new Promise((resolve,reject) => {
				axios.post("http://localhost:8085/api/teacher", teacher)
				.then(response => {
					resolve(response);
				})
				.catch(error => {
					reject(error);
				})

			});
		},
		registerStudentClassAction(_, student){
			student.pass = null;
			return new Promise((resolve,reject) => {
				axios.post("http://localhost:8085/api/register-student/", student)
				.then(response => {
					resolve(response);
				})
				.catch(error => {
					reject(error);
				})
			});
		},
		createClassAction(_, classData){
			return new Promise((resolve,reject) => {
				axios.post("http://localhost:8085/api/class/teacher/" + classData.teacherId, {'name': classData.name}, { headers: {'Content-Type': 'application/json'}})
				.then(response => {
					resolve("http://localhost:8080" + response.data.urlInvite);
				})
				.catch(error => {
					reject(error);
				})
			});
		}
	},
	getters: {
		getPageName: state => {
			return state.pageName;
		},
		getBackUrl: state => {
			return state.backUrl;
		},
		states: state => {
			let mappedStates = state.states.map(state => {return {value: state.sigla, text: state.nome}});
			mappedStates.unshift({value: null, text: "Estado"})
			return mappedStates;
		},
		cities: state => {
			let mappedCities = state.cities.map(city => {return {value: city.nome, text: city.nome}});
			mappedCities.unshift({value: null, text: "Cidade"})
			return mappedCities;
		},
		actualUser: state => {
			return state.actualUser
		},
		actualUserId: state => {
			let user = JSON.parse(sessionStorage.getItem("actualUser")).id
			console.log(state.actualUser);
			return user
		},
		getUserType: state => {
			let user = JSON.parse(sessionStorage.getItem("actualUser")).education ? "teacher" : "student";
			console.log(state.actualUser);
			return user;
		},
		modules: state => {
			return state.modules;
		},
		lessons : state => {
			return state.actualModule.lessons;
		},
		questions: state => {
			return state.actualModule.questions;
		}
	}
});