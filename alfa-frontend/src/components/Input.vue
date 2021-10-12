<template>
    <b-input class="primaryInput mt-2" v-model="proxyValue" :placeholder="placeholder" :type="type"></b-input>
</template>

<script>
    export default {
        props: {
            type: String,
            placeholder: String,
            value: String
        },
        computed :{
            proxyValue: {
                get(){
                    return this.value
                },
                set(newValue){
                    this.$emit("input", newValue);
                }
            }
        }
    }
</script>

<style scoped>
    input::-webkit-input-placeholder{
        padding-right: 20px !important;
        color: var(--primary-btn-palceholder-color) !important;
    }

    .primaryInput{
        background-color:var(--primary-input-color);
        border-radius: 16px;
        border: none;
    }
    
    .primaryInput:focus{
        background-color:var(--primary-input-color);
        color: var(--primary-btn-focus-color);
        border: none;
    }
</style>