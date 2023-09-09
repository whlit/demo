<template>
  <n-config-provider :theme="theme" :locale="locale" :date-locale="dateLocale">
    <div :style="{ height: '100vh', width: '100%', position: 'relative' }">
      <n-layout position="absolute">
        <Header />
        <n-layout has-sider position="absolute" :style="{ top: '64px' }">
          <Sider />
          <n-layout-content>
            Content
          </n-layout-content>
        </n-layout>
      </n-layout>
    </div>
  </n-config-provider>
</template>
<script setup lang="ts">
import { ref } from 'vue'
import { GlobalTheme, zhCN, dateZhCN } from 'naive-ui'


const theme = ref<GlobalTheme | null>(null)

const locale = ref(zhCN)
const dateLocale = ref(dateZhCN)

</script>
<style scoped></style>