<template>
        <b-form-select class="primarySelect mt-2" v-model="proxyValue" :options="data.options" @change="$emit('selectChanged')"/>
</template>

<script>
    export default {
        props: {
            data: Object,
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
    .primarySelect{
        padding-right: 20px !important;
        background-color: var(--primary-input-color)!important;
        border-radius: 16px;
        border: none;
        width: 100%;
        padding: 0.375rem 0.75rem;
        color: var(--primary-btn-palceholder-color);
    }

    .primarySelect:focus{
        color: var(--primary-btn-focus-color);
    }

    .primarySelect:focus-visible{
        outline: 0;
        box-shadow: 0 0 0 0.25rem rgb(13 110 253 / 25%);
    }
</style>