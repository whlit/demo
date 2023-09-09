<template>
  <n-layout-sider bordered show-trigger collapse-mode="width" :collapsed-width="64" :width="240"
    :native-scrollbar="false">
    <n-menu :collapsed-width="64" :collapsed-icon-size="22" :options="menuOptions" />
  </n-layout-sider>
</template>
<script setup lang="ts">
import { MenuOption, NIcon } from 'naive-ui';
import { LeafOutline } from '@vicons/ionicons5'
import { Component, h } from 'vue';

function renderIcon(icon: Component) {
  return () => h(NIcon, null, { default: () => h(icon) })
}

const menuOptions: MenuOption[] = [
  {
    label: 'Spring',
    key: 'spring',
    icon: renderIcon(LeafOutline)
  }
]
</script>
<style scoped></style>