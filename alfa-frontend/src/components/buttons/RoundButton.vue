<template>
    <b-button @click="emitClick" class="roundBtn">
        <img v-if="icon === 'icon-right'" class="icon-right" src="../../assets/icon-white-right.png"/>
        <img v-else-if="icon === 'icon-left'" class="icon-left" src="../../assets/icon-white-left.png"/>
    </b-button>
</template>

<script>
    export default {
        props: {
            icon: {
                type: String,
            },
        },
        methods: {
            emitClick(){
                this.$emit("click");
            }
        }
    }
</script>

<style scoped>
    .roundBtn{
        background-color: var(--primary-btn-color);
        border: none;
        border-radius: 50%;
        width: 55px;
        height: 55px;
    }
    
    .roundBtn::placeholder {
        font-size: 18px;
    }

    .roundBtn:hover{
        background-color: var(--primary-btn-color-hover);
    }

    .roundBtn:focus{
        background-color: var(--primary-btn-color-hover);
    }

    .icon-right{
        margin-left: 2px;
        margin-bottom: 4px;
    }

    .icon-left{
        margin-right: 2px;
        margin-bottom: 4px;
    }
</style>