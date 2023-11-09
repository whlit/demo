<template>
  <n-layout-header class="nav" bordered>
    <div class="ui-logo">
      <img class="logo" :src="whlit" />
      <span>Whlit Demo</span>
    </div>
    <div>

    </div>
    <div class="nav-end">
      <n-button text>
        English
      </n-button>
      <n-button text>
        深色
      </n-button>
    </div>
  </n-layout-header>
</template>
<script setup lang="ts">
import whlit from '@/assets/1024.png'
</script>
<style scoped>
.nav {
  display: grid;
  padding: 0 20px;
  grid-template-columns: var(--sider-width) 1fr auto;
  height: var(--header-height);
}

.nav-end {
  display: flex;
  align-items: center;
}
.nav-end> * {
  margin-right: 14px;
}
.ui-logo {
  display: flex;
  font-size: 18px;
}

.ui-logo>img {
  width: 32px;
  height: 32px;
  margin-right: 10px;
}

.nav, .ui-logo {
  align-items: center;
}</style>