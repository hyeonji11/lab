<template>
  <div class="counter">
    <button @click="decrement" :disabled="count.value <= min">-</button>
    <input
        type="number"
        v-model.number="inputValue"
        @blur="onInputBlur"
        class="value-input"
    />
    <button @click="increment" :disabled="count.value >= max">+</button>
  </div>
</template>

<script setup>
import {ref} from 'vue';

// Props
const props = defineProps({
  modelValue: {
    type: Number,
    required: true
  },
  min: {
    type: Number,
    default: -Infinity
  },
  max: {
    type: Number,
    default: Infinity
  }
});
// Emits
const emit = defineEmits(['update:modelValue']);

// 내부 상태 관리
const count = ref(props.modelValue);
const inputValue = ref(props.modelValue);

function increment() {
  if (count.value < props.max) {
    count.value++;
    inputValue.value = count.value;
    emit('update:modelValue', count.value);
  }
}

function decrement() {
  if (count.value > props.min) {
    count.value--;
    inputValue.value = count.value;
    emit('update:modelValue', count.value);
  }
}

function onInputBlur() {
  let val = Number(inputValue.value);
  if (isNaN(val)) val = count.value; // 잘못된 숫자 입력 시 원복
  val = Math.max(props.min, Math.min(props.max, val)); // 범위 제한
  count.value = val;
  inputValue.value = val;
  emit('update:modelValue', val);
}
</script>

<style scoped>
button:disabled {
  opacity: 0.5;
  cursor: not-allowed;
}
input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
}
</style>