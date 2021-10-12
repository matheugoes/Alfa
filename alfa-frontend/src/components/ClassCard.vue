<template>
    <div :class="newclass">
        <round-button v-if="icon === 'icon-left'" icon="icon-left"/>
        <h1>{{title}}</h1>
        <round-button v-if="icon === 'icon-right'" icon="icon-right"/>
    </div>
</template>

<script>
import RoundButton from './buttons/RoundButton.vue'

export default {
    components: {RoundButton},
    props: {
        newclass: {
            type: String
        },
        title: {
            type: String,
        },
        icon: {
            type: String,
        },
    },
}
</script>

<style>
    .old-classes{
        font-size:16px;
        margin-top: 1.5rem;
        height: 60px;
        display: flex;
        flex-direction: row;
        align-items: center;
        justify-content: space-between;
        padding: 20px;
        background-color: var(--primary-input-color);
        border: none;
        border-radius: 22px;
        cursor: pointer;
        text-align: justify;
    }

    .old-classes h1{
        margin: 0px;
        text-align: center;
        font-size: 20px;
    }

    .old-classes button {
        width: 35px!important;
        height: 35px!important;
    }

    .class {
        margin-top: 0.8rem;
        height: 90px;
        display: flex;
        flex-direction: row;
        align-items: center;
        justify-content: space-between;

        padding: 20px;
        background-color: var(--primary-input-color);
        border: none;
        border-radius: 22px;
        cursor: pointer;
        text-align: justify;
    }

    .class h1{
        margin: 0px;
        font-weight: 600;
        font-size: 30px;
        color: var(--primary-btn-focus-color);
    }
</style>