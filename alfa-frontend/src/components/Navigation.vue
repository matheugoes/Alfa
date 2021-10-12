<template>
    <div class="navigation">
        <div @click="home" class="home">
            <img class="icon" src="../assets/home.png"/>
            <p>Início</p>
        </div>
        <div @click="search" class="search">
            <img class="icon" src="../assets/search.png"/>
            <p>Buscar</p>
        </div>
        <div @click="notifications" class="notification">
            <img class="icon" src="../assets/notification.png"/>
            <p>Notificações</p>
        </div>
        <div @click="profile" class="profile">
            <img class="icon" src="../assets/profile.png"/>
            <p>Perfil</p>
        </div>
    </div>           
</template>

<script>
    export default {
        name: 'Navigation',
        methods: {
            home() {
                this.$router.push('/home');
            },
            search() {
                this.$router.push('/search');
            },
            notifications() {
                this.$router.push('/notifications');
            },
            profile() {
                this.$router.push('/profile');
            }
        }
    }
</script>

<style scoped>
    .navigation {
        font-size: 10px;
        background-color: var(--primary-input-color);
        border-radius: 22px;
        height: 70px;
        display: flex;
        justify-content: space-around;
        align-items: center;
        padding: 10px!important;
        max-width: calc(600px - var(--bs-gutter-x))!important;
        width: calc(100% - var(--bs-gutter-x)) !important;
        position: fixed !important;
        /* align-self: flex-end; */
        bottom: 0px !important;
        padding: 0px!important;
        margin-left: calc(var(--bs-gutter-x) * 0.5) !important;
        margin-right: calc(var(--bs-gutter-x) * 0.5) !important;
        margin-bottom: calc(var(--bs-gutter-x) * 0.5) !important
    }

    .navigation div{
        width: 25%;
        padding-top: 5px;
        cursor: pointer;
    }

    p {
        padding-top: 2px;
        margin-block-start: 0px;
        margin-block-end: 0px;
    }
</style>