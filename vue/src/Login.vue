<template>
    <div class="form-group d-flex justify-content-center">
        <a href="http://localhost:8080/oauth2/authorization/google?redirect_uri=http://localhost:3000/oauth2/redirect">
            <img class="bi me-2" width="55" height="55" src="./assets/google.png" />
        </a>
<!--        <a href="http://localhost:8080/oauth2/authorize/naver?redirect_uri=http://localhost:3001/oauth2/redirect">-->
<!--            <img class="bi me-2" width="55" height="55" src="assets/naver.png" />-->
<!--        </a>-->
        <a href="http://localhost:8080/oauth2/authorization/kakao?redirect_uri=http://localhost:3000/oauth2/redirect">
            <img class="bi me-2" width="55" height="55" src="./assets/kakao.png" />
        </a>
    </div>
</template>

<script>
export default {
    name: 'Login'
}
</script>

<style scoped>

</style>