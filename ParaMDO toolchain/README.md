# ParaMDO Toolchain

ParaMDO toolchain is developed on top of the Eclipse platform. A release for Windows x86-64 architecture is public available.

## Installation

1. Download the latest release from [the releases page](https://github.com/DarkestSky/ParaMDO/releases).

2. Unzip the downloaded file.

3. Run `ParaMDO.exe` in the unzipped folder.

4. Select a workspace folder.

## Usage

The ParaMDO toolchain provides a workbench for CIM Modeling. You can difine your own CIM model here.

By CIM2PIM Semantic Mapper and PIM2PSM Semantic Mapper, you can transform your CIM model to PIM model and then to PSM model automatically.

The result PSM model is a BPMN file and can be accepted by Camunda 7 engine.

## Minimal Camunda 7 Runtime Environment

To evalute the PSM model, we also provide a minimal Camunda 7 runtime environment. It is developed as a Spring Boot integration.

The source code of the minimal Camunda 7 runtime environment is available in the `ParaMDO-Camunda` folder.
