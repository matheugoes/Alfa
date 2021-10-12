<template>
    <div class="module">
        <div class="module-start">
            <h1>{{title}}</h1>
            <p>{{description}}</p>
        </div>
        <div class="module-end">
            <p class="module-data">{{classes}} aulas</p>
            <p class="module-data">{{activies}} atividades</p>
            <div class="progress">
                <div class="progress-bar" role="progressbar" style="width: 25%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    props: {
        title: {
            type: String,
        },
        description: {
            type: String,
        },
        classes: {
            type: String,
        },
        activies: {
            type: String,
        }
    }
}
</script>

<style>
    .module-content{
        margin-top: 0.8rem;
        width: 100%;
        overflow-x: scroll;
        display: flex;
        flex-direction: row;
        flex-wrap: nowrap;
    }

    .module{
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        margin-left: calc(var(--bs-gutter-x) * 0.5);
        padding: 15px;
        min-width: 150px;
        width: 150px;
        height: 200px;
        background-color: #f2f2f2;
        border-radius: 22px;
    }

    .module h1{
        margin: 0px!important;
        margin-bottom: 5px!important;
        font-size: 20px;
    }

    .module p{
        font-size: 16px;
    }

    .module-data{
        font-size: 14px!important;
        margin-bottom: 0px;
    }
    
    .progress {
        margin-top: 5px;
    }
</style>